package free.android.lib;

import android.content.Context;
import android.text.ClipboardManager;

public class FALSystem
{
	Context context;
	
	public FALSystem(Context context)
	{
		this.context = context;
	}
	
	/** Copy text in clipboard
	 * 
	 * @param text
	 * Text to set in clipboard
	 */
	public void copyToClipboard(String text)
	{
		ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
		clipboard.setText(text);
	}
}
