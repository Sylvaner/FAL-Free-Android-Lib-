/** Class for show messages
 * 
 */
package free.android.lib;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.Toast;

public class FALMessage
{
	private final int DEFAUT_TOAST_DURATION = Toast.LENGTH_LONG;
	
	private Context context;
	
	public FALMessage(Context context)
	{
		this.context = context;
	}
	
	/**
	 * Show standard toast message
	 *
	 * @param text
	 * Text to show
	 */
	public void showToastMessage(String text)
	{
		Toast.makeText(context, text, DEFAUT_TOAST_DURATION).show();
	}
	
	/** Show standard toast message with duration param
	 *
	 * @param text
	 * Text to show
	 * @param duration
	 * Duration of the toast (Toast.LENGTH_SHORT, Toast.LENGTH_LONG)
	 */
	public void showToastMessage(String text, int duration)
	{
		Toast.makeText(context, text, duration).show();
	}
	
	/** Show dialog with only text
	 * 
	 * @param text
	 * Text to show
	 */
	public void showDialogMessage(String text)
	{
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setMessage(text)
		      .create();

	}
	
	/** Show dialog with text and title
	 * 
	 * @param text
	 * Text to show
	 * @param title
	 * Text on title
	 */
	public void showDialogMessage(String title, String text)
	{
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setMessage(text)
			  .setTitle(title)
		      .create()
		      .show();
	}
	
	/** Show dialog with text, title and button
	 * 
	 * @param text
	 * Text to show
	 * @param title
	 * Text on title
	 * @param buttonText
	 * Text on button
	 */
	public void showDialogMessage(String title, String text, String buttonText)
	{
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setMessage(text)
		      .setTitle(title)
		      .setPositiveButton(buttonText, null)
		      .create();
	}
	
	/** Show dialog with text, title and button with listener
	 * 
	 * @param text
	 * Text to show
	 * @param title
	 * Text on title
	 * @param buttonText
	 * Text on button
	 * @param buttonListener
	 * Listener on valid
	 */
	public void showDialogMessage(String title, String text, String buttonText, DialogInterface.OnClickListener listener)
	{
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setMessage(text)
		      .setTitle(title)
		      .setPositiveButton(buttonText, listener)
		      .create();
	}
	
	/** Show dialog with webview
	 * 
	 * @param title
	 * Text on title
	 * @param data
	 * Html data for content
	 * @param buttonText
	 * Text on button, no button if null
	 * @param buttonListener
	 * Listener for button
	 */
	public void showDialogWebView(String title, String data, String buttonText, DialogInterface.OnClickListener listener)
	{
		WebView webView = new WebView(context);
		webView.loadData(data, "text/html", "utf-8");
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		if (buttonText != null)
			dialog.setPositiveButton(buttonText, listener);
		dialog.setTitle(title)
		      .setView(webView)
		      .show();
	}
	
	/** Show notification in status bar
	 * 
	 * @param resAppName
	 * String resource id for app name
	 * @param resIcon
	 * Drawable resource id of icon
	 * @param title
	 * Title of the notification
	 * @param text
	 * Text of the notification
	 */
	public void showNotification(int resAppName, int resIcon, String title, String text)
	{
		showNotification(resAppName, resIcon, title, text, new Intent());
	}

	/** Show notification in status bar with action
	 * 
	 * @param resAppName
	 * String resource id for app name
	 * @param resIcon
	 * Drawable resource id of icon
	 * @param title
	 * Title of the notification
	 * @param text
	 * Text of the notification
	 * @param action
	 * Action launch on click
	 */
	public void showNotification(int resAppName, int resIcon, String title, String text, Intent action)
	{
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(resIcon, title, System.currentTimeMillis());
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, action, 0);
		notification.setLatestEventInfo(context, title, text, contentIntent);
		notificationManager.notify(resAppName, notification);
		
	}
}
