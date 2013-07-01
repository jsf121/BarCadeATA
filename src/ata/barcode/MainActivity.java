package ata.barcode;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnsc=(Button) findViewById(R.id.btnscanner);
		btnsc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tarea();
			}
		});
	}
	
	private void tarea() {
		//Toast t=Toast.makeText(MainActivity.this, "Ingreso!!", Toast.LENGTH_LONG);
		//t.show();
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		  if (scanResult != null) {
			String barcode;
			String type;
			  
			barcode = scanResult.getContents();
			type = scanResult.getFormatName();
			
			EditText etBarcode=(EditText) findViewById(R.id.txtcodigo);
			EditText etTipo=(EditText) findViewById(R.id.txttipo);
			
			etBarcode.setText(barcode);
			etTipo.setText(type);
			
		  }
	}
	
	

}
