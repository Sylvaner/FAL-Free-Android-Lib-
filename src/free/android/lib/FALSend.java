package free.android.lib;

import android.content.Context;
import android.content.Intent;

public class FALSend
{
	Context context;
	
	public FALSend(Context context)
	{
		this.context = context;
	}
	
	/** Send a SMS
	 * 
	 * @param content
	 * Content of the SMS
	 */
	public void sendSMS(String content)
	{
    	final Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.putExtra("sms_body", content); 
    	intent.setType("vnd.android-dir/mms-sms");
    	context.startActivity(intent);
    }
	
	/** Send an email
	 * 
	 * @param email
	 * Contact to send
	 * @param subject
	 * Subject of the mail
	 * @param content
	 * Content of the mail
	 * @param chooser
	 * Message to inform user of the action
	 */
	public void sendMail(String email, String subject, String content, String chooser)
	{
		final Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("plain/text");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, content);
		context.startActivity(Intent.createChooser(intent, chooser));
	}
}
