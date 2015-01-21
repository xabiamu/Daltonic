package es.capsule.daltonic;

import java.nio.IntBuffer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bitmap bmp = Bitmap.createBitmap(100, 100, Config.ARGB_8888);

		IntBuffer buffer = IntBuffer.allocate(bmp.getWidth() * bmp.getHeight());
	    buffer.rewind();
	    
	    while ( buffer.position() < buffer.limit() ) {
	    	buffer.put( Color.BLUE );
	    }
	    
	    buffer.rewind();
	    bmp.copyPixelsFromBuffer(buffer);
	    
	    ImageView view = new ImageView(this);
	    view.setImageBitmap(bmp);
	    
	    setContentView(view);
	}

}
