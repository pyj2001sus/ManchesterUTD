package kr.co.tjeit.manchesterutd.util;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class AsyncHttpRequest {

	public interface HttpResponseHandler {
		boolean onPrepare();		
		void onResponse(String response);
		void onFinish();
		void onCancelled();
	}



	public static void post(final Context context, final String url , final Map<String, String> params, final boolean showProgress, final HttpResponseHandler handler) {


		if (isNetworkAvailable(context)) {
			AsyncTaskHandler async = new AsyncTaskHandler() {
				@Override
				public String doInBackground() {

					if (params == null)
						return HttpRequest.post(url).body();
					else
						return HttpRequest.post(url).form(params).body();
				}
			};

			new AsyncHttpRequestTask(context, async, showProgress, handler).execute();
		} else {
			AlertDialog.Builder alert = new AlertDialog.Builder(context);
			alert.setTitle("인터넷 연결 실패");
			alert.setMessage("인터넷에 연결 할 수 없습니다. 와이파이 / 데이터를 확인해주세요.");
			alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					System.exit(0);
				}
			});
			alert.show();
		}

	}

	public static void get(final Context context, final String url , final Map<String, String> params, final boolean showProgress, final HttpResponseHandler handler) {


		if (isNetworkAvailable(context)) {
			AsyncTaskHandler async = new AsyncTaskHandler() {
				@Override
				public String doInBackground() {

					if (params == null)
						return HttpRequest.get(url).body();
					else
						return HttpRequest.get(url).form(params).body();
				}
			};

			new AsyncHttpRequestTask(context, async, showProgress, handler).execute();
		} else {
			AlertDialog.Builder alert = new AlertDialog.Builder(context);
			alert.setTitle("인터넷 연결 실패");
			alert.setMessage("인터넷에 연결 할 수 없습니다. 와이파이 / 데이터를 확인해주세요.");
			alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					System.exit(0);
				}
			});
			alert.show();
		}

	}

    static boolean isNetworkAvailable(final Context context) {
//        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;

//		안드로이드 기기의 인터넷 연결 상태를 관리하는 서비스 호출.
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//		관리 서비스가 가진 모든 인터넷 연결 현황 받아오기.
		NetworkInfo ni = cm.getActiveNetworkInfo();

//		모든 현황을 받아왔는데 아무것도 없을경우
		if (ni == null) {
//			인터넷 연결이 불가능하므로 false
			return false;
		}
		else {
//			인터넷연결이 어쨌든 가능. true
			return true;
		}

    }


    static boolean isWifiConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		if (ni.isConnected()) {
//			와이파이가 연결된 상황.  true
			return true;
		}
		else {
//			와이파이가 연결되지 않은 상황. false
			return false;
		}
	}


    //Checking Internet Connection

//	public static void postImageFiles(final Context context, final String url , final int chiefIndex , final Map<String, String> params, final ArrayList<Bitmap> bitmapList, final HttpResponseHandler handler) {
//		AsyncTaskHandler async = new AsyncTaskHandler() {
//			@Override
//			public String doInBackground() {
//
//				HttpRequest request = HttpRequest.post(url);
//				for (Map.Entry<?, ?> entry : params.entrySet())
//				{
//					request.part(entry.getKey().toString(), entry.getValue().toString());
//				}
//
//				for (int i=0;i<bitmapList.size();i++)
//				{
//					Bitmap myBitmap = bitmapList.get(i);
//					ByteArrayOutputStream bao = new ByteArrayOutputStream();
//					myBitmap.compress(Bitmap.CompressFormat.JPEG, 70, bao);
//					byte [] ba = bao.toByteArray();
//					ByteArrayInputStream bs = new ByteArrayInputStream(ba);
//					SimpleDateFormat sdfNow = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
//					String dateTime = sdfNow.format(new Date(System.currentTimeMillis()));
//
//					String fileName = "cm_product_"+ContextUtil.getUserPhoneMum(context)+"_"+dateTime+".jpg";
//					if (i == chiefIndex) {
//						request.part("chiefImageName", fileName);
//					}
//					request.part("contentPhoto"+i, fileName,"image/jpg", bs);
//				}
//
//
//
//
//				return request.body();
//			}
//		};
//
//		new AsyncHttpRequestTask(context, async, true, handler).execute();
//	}

	public static void postWithImageFile(final Context context,
										 final String url ,
										 final Map<String, String> params,
										 final Bitmap bitmap,
										 final String fileType,
										 final HttpResponseHandler handler) {
		AsyncTaskHandler async = new AsyncTaskHandler() {
			@Override
			public String doInBackground() {

				HttpRequest request = HttpRequest.post(url);
				for (Map.Entry<?, ?> entry : params.entrySet())
				{
					Log.d("tag", entry.getKey().toString());
					request.part(entry.getKey().toString(), entry.getValue().toString());
				}

				if (bitmap != null)
				{
//					Bitmap => 웹에 전송 가능한 byte[] 형태로 변환
					Bitmap myBitmap = bitmap;
					ByteArrayOutputStream bao = new ByteArrayOutputStream();
					myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bao);
					byte [] ba = bao.toByteArray();
					ByteArrayInputStream bs = new ByteArrayInputStream(ba);

//					2. 파일 명 지정. my_profile20170907_130511321.jpg
					SimpleDateFormat sdfNow = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
					String dateTime = sdfNow.format(new Date(System.currentTimeMillis()));

//					 profile, post
					String fileName = fileType+"_"+dateTime+".jpg";

					request.part("image", fileName,"image/jpg", bs);
				}





				return request.trustAllCerts().body();
			}
		};

		new AsyncHttpRequestTask(context, async, true, handler).execute();
	}


	public static void postProfileImageFile(final Context context, final String url , final Map<String, Object> params, final Bitmap bitmap, final String fileType, final HttpResponseHandler handler) {
		AsyncTaskHandler async = new AsyncTaskHandler() {
			@Override
			public String doInBackground() {

				HttpRequest request = HttpRequest.post(url);
				for (Map.Entry<?, ?> entry : params.entrySet())
				{
					request.trustAllCerts().part(entry.getKey().toString(), entry.getValue().toString());
				}

				if (bitmap != null)
				{
					Bitmap myBitmap = bitmap;
					ByteArrayOutputStream bao = new ByteArrayOutputStream();
					myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bao);
					byte [] ba = bao.toByteArray();
					ByteArrayInputStream bs = new ByteArrayInputStream(ba);
					SimpleDateFormat sdfNow = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
					String dateTime = sdfNow.format(new Date(System.currentTimeMillis()));

					String fileName = "sharetdd_"+fileType+"_"+dateTime+".jpg";

					request.trustAllCerts().part("profile_photo", fileName,"image/jpg", bs);
				}





				return request.trustAllCerts().body();
			}
		};

		new AsyncHttpRequestTask(context, async, true, handler).execute();
	}


	private interface AsyncTaskHandler {
		String doInBackground();
	}

	private static class AsyncHttpRequestTask extends AsyncTask<Void, Void, String> {

		protected Context mContext = null;
		private ProgressDialog mProgress = null;
		private AsyncTaskHandler mHandler = null;
		private HttpResponseHandler mResponseHandler = null;
		private boolean showProgress = false;

		public AsyncHttpRequestTask(Context context, AsyncTaskHandler handler, boolean isInsert, HttpResponseHandler responseHandler) {
			mContext = context;
			mHandler = handler;
			mResponseHandler = responseHandler;
			this.showProgress = isInsert;
		}

		@Override
		protected void onPreExecute() {

			Log.i("CHO", "onPreExecute");

			try {
				if (mContext != null && showProgress) {

					mProgress = new ProgressDialog(mContext);
//					mProgress .getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

//					mProgress.setTitle(  );
					mProgress.setMessage("잠시만 기다려주세요..");
					mProgress.show();

					if (mResponseHandler != null)
						if (!mResponseHandler.onPrepare())
							cancel(true);

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Void... arg) {
			return mHandler.doInBackground();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if (mResponseHandler != null) {
				mResponseHandler.onResponse(result);
				mResponseHandler.onFinish();
			}
			if (mProgress != null)
			{
				mProgress.dismiss();

				//mProgress = null;

			}

		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
			if (mResponseHandler != null)
				mResponseHandler.onCancelled();
			if (mProgress != null)
				mProgress.dismiss();			
		}
	}

}