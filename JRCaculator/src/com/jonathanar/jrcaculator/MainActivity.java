package com.jonathanar.jrcaculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	String x = "";
	int flagpu = 0;
	public int flagpas = 0;
	double Total = 0, x1, y1;
	int flagl = 0;
	int ope = 0;

	public String im(String a) {
		float p = Float.parseFloat(a);
		p *= -1;
		p = (float) Math.sqrt(p);
		a = p + "i";
		return a;
	}

	public void procesa(String a) {
		Total = Double.parseDouble(a);
		x = "";
	}

	public String resu() {
		return x;
	}

	public void almacena(String a) {
		if (flagl > 0) {
			x = "";
			flagl = 0;
		}
		x += a;
	}

	public String get() {
		return x;
	}

	public String resultad() {
		switch (ope) {
			case 1: {
				Total = x1 + y1;
				x = "" + Total;
				break;
			}
			case 2: {
				Total = x1 * y1;
				x = "" + Total;
				break;
			}
			case 3: {
				Total = x1 - y1;
				x = "" + Total;
				break;
			}
			case 4: {	
				Total = x1 / y1;
				x = "" + Total;
				break;
			}
			default: {
				x = "" + y1;
				break;
			}
		}

		x1 = 0;
		y1 = 0;
		flagpu = 0;
		return x;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		final TextView Resultado = (TextView) findViewById(R.id.Resultado);
		final Button boton1 = (Button) findViewById(R.id.Boton1);
		final Button boton2 = (Button) findViewById(R.id.Boton2);
		final Button boton3 = (Button) findViewById(R.id.Boton3);
		final Button boton4 = (Button) findViewById(R.id.Boton4);
		final Button boton5 = (Button) findViewById(R.id.Boton5);
		final Button boton6 = (Button) findViewById(R.id.Boton6);
		final Button boton7 = (Button) findViewById(R.id.Boton7);
		final Button boton8 = (Button) findViewById(R.id.Boton8);
		final Button boton9 = (Button) findViewById(R.id.Boton9);
		final Button botonpunto = (Button) findViewById(R.id.Botonpunto);
		final Button boton0 = (Button) findViewById(R.id.Boton0);
		final Button botonsuma = (Button) findViewById(R.id.Botonsuma);
		final Button botonresta = (Button) findViewById(R.id.Botonresta);
		final Button botonmulti = (Button) findViewById(R.id.Botonmulti);
		final Button botondiv = (Button) findViewById(R.id.Botondiv);
		final Button del = (Button) findViewById(R.id.DEL);
		final Button botonC = (Button) findViewById(R.id.botonC);
		final Button igual = (Button) findViewById(R.id.Botonigual);
		final Button botonPabre = (Button) findViewById(R.id.botonPabre);
		final Button botonPcierra = (Button) findViewById(R.id.botonPcierra);
		
		
		boton0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("0");
				Resultado.setText(Resultado+get());
			}
		});

		boton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("1");
				Resultado.setText(get());
			}
		});

		boton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("2");
				Resultado.setText(get());
			}
		});
		
	    boton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("3");
				Resultado.setText(get());
			}
		});

	    boton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("4");
				Resultado.setText(get());
			}
		});

		boton5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("5");
				Resultado.setText(get());
			}
		});
		
		boton6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("6");
				Resultado.setText(get());
			}
		});

		boton7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("7");
				Resultado.setText(get());
			}
		});

		boton8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("8");
				Resultado.setText(get());
			}
		});

		boton9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				almacena("9");
				Resultado.setText(get());
			}
		});

		botonpunto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (flagpu == 0) {
					almacena(".");
					flagpu++;
				}
				Resultado.setText(get());
			}
		});
		
		botonsuma.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ope = 1;
				flagl++;
				if (x1 == 0) {
					x = Resultado.getText().toString();
					x1 = Double.parseDouble(x);
					Resultado.setText(x);
				} else {
					y1 = Double.parseDouble(Resultado.getText().toString());
					Resultado.setText(resultad());
				}
			}
		});

		botonresta.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("".equals(x)) {
					almacena("-");
				} else {
					ope = 3;
					flagl++;
					if (x1 == 0) {
						x = Resultado.getText().toString();
						x1 = Double.parseDouble(x);
						Resultado.setText(x);
					} else {
						y1 = Double.parseDouble(Resultado.getText().toString());
						Resultado.setText(resultad());
					}
				}
			}
		});

		botonmulti.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ope = 2;
				if (x1 == 0) {
					x = Resultado.getText().toString();
					x1 = Double.parseDouble(x);
					Resultado.setText(x);
				} else {
					y1 = Double.parseDouble(Resultado.getText().toString());
					Resultado.setText(resultad());
				}
				flagl++;
			}
		});

		botondiv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ope = 4;
				flagl++;
				if (x1 == 0) {
					x = Resultado.getText().toString();
					x1 = Double.parseDouble(x);
					Resultado.setText(x);
				} else {
					y1 = Double.parseDouble(Resultado.getText().toString());
					Resultado.setText(resultad());
				}
			}
		});
		
		botonC.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				x = "";
				Resultado.setText(x);
			}
		});
	
		del.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){ 
				if(x.length()>0) 
				x=x.substring(0, (x.length()-1)); 
				Resultado.setText(x); 
			}
		});

		igual.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				y1 = Double.parseDouble(Resultado.getText().toString());
				Resultado.setText(resultad());
			}
		});
		
		botonPabre.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Resultado.setText("("); 	
			}
		});
		
		botonPcierra.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Resultado.setText(")"); 	
			}
		});
	}
}
