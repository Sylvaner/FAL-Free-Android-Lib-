/** Class for internet use
 * 
 */

package free.android.lib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class FALInternet
{
	private Context context;
	
	public FALInternet(Context context)
	{
		this.context = context;
	}
	
	/**
	 * Open browser with the selected url
	 * @param url
	 * url to open
	 */
	public void openBrowser(String url)
	{
		final Uri uri = Uri.parse(url);
		final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		context.startActivity(intent);
	}
}
