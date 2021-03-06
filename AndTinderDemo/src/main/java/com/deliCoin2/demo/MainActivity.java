/**
 * TAndTinder is a native library for Android that provide a
 * Tinder card like effect. A card can be constructed using an
 * image and displayed with animation effects, dismiss-to-like
 * and dismiss-to-unlike, and use different sorting mechanisms.
 */

package com.deliCoin2.demo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import com.deliCoin2.bean.Pics;
import com.deliCoin2.model.CardModel;
import com.deliCoin2.view.CardContainer;
import com.deliCoin2.view.SimpleCardStackAdapter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	public static final String TAG = "MainActivity";
	public  List<Pics> listPics= new ArrayList<Pics>();
	public Bitmap bitmap = null;
	SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);
    /**
     * This variable is the container that will host our cards
     */
	private CardContainer mCardContainer;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Firebase.setAndroidContext(this);

		//requestWindowFeature(Window.FEATURE_NO_TITLE);

		//Enable display title
//		this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
//		setContentView(R.layout.main_title);
//		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_title);
		//--End Title

		setContentView(R.layout.mainlayout);//todo:rrcc
		mCardContainer = (CardContainer) findViewById(R.id.layoutview);

//		HttpURLConnection urlConnection = null;
//		BufferedReader reader = null;
//		final String BASE_URL = "https://delicoin.firebaseio.com/mobilePics";
//		Uri builtUrlData = Uri.parse(BASE_URL).buildUpon().build();
//		URL url = new URL(builtUrlData.toString());


		Resources r = getResources();
		adapter.add(new CardModel("Ensalada Casero Jota", "Description goes here","", r.getDrawable(R.drawable.ensalada_casero_jota)));
		adapter.add(new CardModel("Ensalada de Mango", "Description goes here","", r.getDrawable(R.drawable.ensalada_de_mango)));
		adapter.add(new CardModel("Ensalada de Pollo", "Description goes here","", r.getDrawable(R.drawable.ensalada_de_pollo)));
		adapter.add(new CardModel("Ensalada de Quinua", "Description goes here","", r.getDrawable(R.drawable.ensalada_de_quinua)));
		adapter.add(new CardModel("Granola Falluta", "Description goes here","", r.getDrawable(R.drawable.granola_falluta)));
		/*adapter.add(new CardModel("Hispania Paella de Carne", "Description goes here","", r.getDrawable(R.drawable.hispaniapaelladecarne2)));
		adapter.add(new CardModel("Hispania Paella Marina", "Description goes here","", r.getDrawable(R.drawable.hispaniapaellamarinera)));
		adapter.add(new CardModel("Hispania Paella Extra de Mariscos", "Description goes here","", r.getDrawable(R.drawable.hispaniapaellaextrademariscos)));
		adapter.add(new CardModel("Hispania Paella Vegetariana", "Description goes here","", r.getDrawable(R.drawable.hispaniapaellavegetariana)));
		adapter.add(new CardModel("Lomo en Pieza", "Description goes here","", r.getDrawable(R.drawable.lomo_en_pieza)));
*/
		/*adapter.add(new CardModel("Bolsillo de Tofu", "Description goes here","", r.getDrawable(R.drawable.redmonkey_bolsillo_de_tofu)));
		adapter.add(new CardModel("Brochetas de Seitan", "Description goes here","", r.getDrawable(R.drawable.redmonkey_brochetas_de_seitan)));
		adapter.add(new CardModel("Burquesa de Frijoles Negros", "Description goes here","", r.getDrawable(R.drawable.redmonkey_burguesa_de_frijolesjpg)));
		adapter.add(new CardModel("Crepas Negras", "Description goes here","", r.getDrawable(R.drawable.redmonkey_crepas_negras)));
		adapter.add(new CardModel("Burguesa de Garbanzo", "Description goes here","", r.getDrawable(R.drawable.redmonkey_burguesa_de_garbanzojpg)));
		adapter.add(new CardModel("Burguesa de Yuca Verde", "Description goes here","", r.getDrawable(R.drawable.redmonkey_burguesa_de_yuca_verjpg)));
		adapter.add(new CardModel("Crepas Negras", "Description goes here","", r.getDrawable(R.drawable.redmonkey_crepas_negras)));
		adapter.add(new CardModel("Desayuno Vegano", "Description goes here","", r.getDrawable(R.drawable.redmonkey_desayuno_vegano)));
		adapter.add(new CardModel("Wrap de Champiniones", "Description goes here","", r.getDrawable(R.drawable.wrap_de_champin_ones)));
		adapter.add(new CardModel("Wrap de Quinua Blanca y Negra", "Description goes here","", r.getDrawable(R.drawable.wrap_de_quinua_blanca_y_negra)));

*/
		/*adapter.add(new CardModel("Hojas de Brocoli", "Description goes here","", r.getDrawable(R.drawable.redmonkey_hojas_de_brocoli)));
		adapter.add(new CardModel("Jugo de Pepino y Apio", "Description goes here","", r.getDrawable(R.drawable.redmonkey_jugo_de_pepino_apio_jpg)));
		adapter.add(new CardModel("Pizza de Berenjena", "Description goes here","", r.getDrawable(R.drawable.redmonkey_pizza_de_berenjena)));
		adapter.add(new CardModel("Pizza de Vegetales", "Description goes here","", r.getDrawable(R.drawable.redmonkey_pizza_de_vegetales)));
		adapter.add(new CardModel("Sandwich de Kolla", "Description goes here","", r.getDrawable(R.drawable.redmonkey_sandwich_de_kolla)));
		adapter.add(new CardModel("Sopa de Papa", "Description goes here","", r.getDrawable(R.drawable.redmonkey_sopa_de_papa)));
		adapter.add(new CardModel("Sopa de Walusa", "Description goes here","", r.getDrawable(R.drawable.redmonkey_sopa_de_walusa_y_porjpg)));
		adapter.add(new CardModel("Sopa Miso", "Description goes here","", r.getDrawable(R.drawable.redmonkey_sopa_miso)));
		adapter.add(new CardModel("Tarta de Chocolate", "Description goes here","", r.getDrawable(R.drawable.redmonkey_tarta_de_chocolate_bjpg)));
		adapter.add(new CardModel("Sandwich de Carne", "Description goes here","", r.getDrawable(R.drawable.sandwich_de_carne_a_la_bbq)));
		adapter.add(new CardModel("Tabla Mixta", "Description goes here","", r.getDrawable(R.drawable.tablamixta)));
*/

		/*Firebase myFirebaseRef = new Firebase("https://delicoin.firebaseio.com/");
		myFirebaseRef.child("mobilePicsWithoutURL").addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				Log.i(TAG, dataSnapshot.getValue().toString());  //prints "Do you have data? You'll love Firebase."
				try {
					for (DataSnapshot picSnapshot : dataSnapshot.getChildren()) {
						Pics data = picSnapshot.getValue(Pics.class);
						listPics.add(data);
					}

					Resources r = getResources();

					if(listPics!=null && listPics.size()>0) {
						int i = 0;
						/*for(Pics pic:listPics)
						{
							String url = "https://delicoin.firebaseapp.com" + pic.getImageUrl();

							*****Retrievedata taskPic = new Retrievedata();
							taskPic.execute(url);****

//							Resources res = getResources();
//							int resourceId = res.getIdentifier(
//									data.getImageUrl(), "drawable", getPackageName() );
//							adapter.add(new CardModel("", "",getDrawable(resourceId) ));
//
//							int result =
//									getResources().getIdentifier(data.getImageUrl(), "drawable", "com.deliCoin2.demo");
							if(i>=30)
							{
								break;
							}
							int result = getApplicationContext().getResources().getIdentifier(
									pic.getImageUrl(), "drawable", getApplicationContext().getPackageName());

//							String uri = "@drawable/"+pic.getImageUrl();
//							int result = getResources().getIdentifier(uri, null, getPackageName());

//							String PACKAGE_NAME = getApplicationContext().getPackageName();
//							String uri = PACKAGE_NAME+":drawable/"+pic.getImageUrl();
//							int result = getResources().getIdentifier(uri, null, null);

							/*CardModel cardModel1 = new CardModel("Brochetas de Seitan", "Description goes here","", r.getDrawable(R.drawable.redmonkey_brochetas_de_seitan));
							CardModel cardModel = new CardModel(pic.getTitle(), "", pic.getCategory(), getResources().getDrawable(result ));
							cardModel.setOnClickListener(new CardModel.OnClickListener() {
								@Override
								public void OnClickListener() {
									Log.i("Swipeable Cards","I am pressing the card");
								}
							});

							cardModel.setOnCardDismissedListener(new CardModel.OnCardDismissedListener() {
								@Override
								public void onLike() {
									User user = User.getInstance();
									Log.i("Swipeable Cards",user.toString());
									Log.i("Swipeable Cards","I like the card");
								}

								@Override
								public void onDislike() {
									Log.i("Swipeable Cards","I dislike the card");
								}
							});

							adapter.add(cardModel);
							i++;
							Log.i(TAG, i+"");

						}*/


						/*//Nuestro código a ejecutar en este momento

						CardModel cardModel = new CardModel("Brochetas de Seitan", "Description goes here", r.getDrawable(R.drawable.redmonkey_brochetas_de_seitan));
						cardModel.setOnClickListener(new CardModel.OnClickListener() {
							@Override
							public void OnClickListener() {
								Log.i("Swipeable Cards","I am pressing the card");
							}
						});

						cardModel.setOnCardDismissedListener(new CardModel.OnCardDismissedListener() {
							@Override
							public void onLike() {
								User user = User.getInstance();
								Log.i("Swipeable Cards",user.toString());
								Log.i("Swipeable Cards","I like the card");
							}

							@Override
							public void onDislike() {
								Log.i("Swipeable Cards","I dislike the card");
							}
						});

						adapter.add(cardModel);*/
						mCardContainer.setAdapter(adapter);
		/*			}
				} catch (Exception e) {
					Log.e(TAG, e.getMessage());
				}
			}

			@Override
			public void onCancelled(FirebaseError error) {
			}
		});

        */

	}

	@Override
	public void onStart(){
		super.onStart();
		if(adapter!=null && adapter.getCount()==0)
		{
			Resources r = getResources();
			adapter.add(new CardModel("Ensalada Casero Jota", "Description goes here","", r.getDrawable(R.drawable.ensalada_casero_jota)));
			adapter.add(new CardModel("Ensalada de Mango", "Description goes here","", r.getDrawable(R.drawable.ensalada_de_mango)));
			adapter.add(new CardModel("Ensalada de Pollo", "Description goes here","", r.getDrawable(R.drawable.ensalada_de_pollo)));
			adapter.add(new CardModel("Ensalada de Quinua", "Description goes here","", r.getDrawable(R.drawable.ensalada_de_quinua)));
			adapter.add(new CardModel("Granola Falluta", "Description goes here","", r.getDrawable(R.drawable.granola_falluta)));
		}
	}

	class Retrievedata extends AsyncTask<String, Void, Bitmap> {
		@Override
		protected Bitmap doInBackground(String... params) {
			Bitmap loadedImage = null;
			URL imageUrl = null;
			try {
				imageUrl = new URL(params[0]);
				HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
				conn.connect();
				loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
				//imageView.setImageBitmap(loadedImage);
			} catch (IOException e) {
				//Toast.makeText(getApplicationContext(), "Error cargando la imagen: " + e.getMessage(), Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
			return loadedImage;
		}
		@Override
		protected void onPostExecute(Bitmap result) {
			if (result != null) {
				bitmap = result;
				// New data is back from the server.  Hooray!
				adapter.add(new CardModel("", "",bitmap ));
			}
		}
	}


}
