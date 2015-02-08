package appewtc.masterung.myishihara;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //Explicit
    private TextView txtQuestion;
    private ImageView imvIshihara;
    private RadioGroup ragChoice;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private Button btnAnswer;
    private int intRadio, intIndex;
    private MyModel objMyModel;
    private String strChoice[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //button Controller
        buttonController();

        //radioButton Controller
        radioButtonController();

        //About MyModel
        aboutMyModel();

    }   // onCreate

    private void aboutMyModel() {

        objMyModel = new MyModel();

        objMyModel.setOnMyModelChangeListener(new MyModel.OnMyModelChangeListener() {
            @Override
            public void onMyModelChangeListener(MyModel myModel) {

                switch (myModel.getIntButton()) {

                    case 2:
                        imvIshihara.setImageResource(R.drawable.ishihara_02);
                        strChoice = getResources().getStringArray(R.array.time2);
                        setUpChoice();
                        break;
                    case 3:
                        imvIshihara.setImageResource(R.drawable.ishihara_03);
                        strChoice = getResources().getStringArray(R.array.time3);
                        setUpChoice();
                        break;
                    case 4:
                        imvIshihara.setImageResource(R.drawable.ishihara_04);
                        strChoice = getResources().getStringArray(R.array.time4);
                        setUpChoice();
                        break;
                    case 5:
                        imvIshihara.setImageResource(R.drawable.ishihara_05);
                        strChoice = getResources().getStringArray(R.array.time5);
                        setUpChoice();
                        break;
                    case 6:
                        imvIshihara.setImageResource(R.drawable.ishihara_06);
                        strChoice = getResources().getStringArray(R.array.time6);
                        setUpChoice();
                        break;
                    case 7:
                        imvIshihara.setImageResource(R.drawable.ishihara_07);
                        strChoice = getResources().getStringArray(R.array.time7);
                        setUpChoice();
                        break;
                    case 8:
                        imvIshihara.setImageResource(R.drawable.ishihara_08);
                        strChoice = getResources().getStringArray(R.array.time8);
                        setUpChoice();
                        break;
                    case 9:
                        imvIshihara.setImageResource(R.drawable.ishihara_09);
                        strChoice = getResources().getStringArray(R.array.time9);
                        setUpChoice();
                        break;
                    case 10:
                        imvIshihara.setImageResource(R.drawable.ishihara_10);
                        strChoice = getResources().getStringArray(R.array.time10);
                        setUpChoice();
                        break;

                }   // switch

            }   //event
        });


    }   // aboutMyModel

    private void setUpChoice() {

        radChoice1.setText(strChoice[0]);
        radChoice2.setText(strChoice[1]);
        radChoice3.setText(strChoice[2]);
        radChoice4.setText(strChoice[3]);

    }   // setUpChoice

    private void radioButtonController() {

        ragChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //Sound Effect
                MediaPlayer soundRadio = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
                soundRadio.start();

                //SetUp intRadio
                switch (checkedId) {

                    case R.id.radioButton:
                        intRadio = 1;
                        break;
                    case R.id.radioButton2:
                        intRadio = 2;
                        break;
                    case R.id.radioButton3:
                        intRadio = 3;
                        break;
                    case R.id.radioButton4:
                        intRadio = 4;
                        break;
                    default:
                        intRadio = 0;
                        break;

                }   // switch


            }   // event
        });

    }   // radioButtonController

    private void buttonController() {

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Efface
                MediaPlayer soundButton = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_long);
                soundButton.start();

                //Check Zero
                checkZero();


            }   //event
        });

    }   // buttonController

    private void checkZero() {

        if (intRadio == 0) {

            MyAlertDialog objMyAlert = new MyAlertDialog();
            objMyAlert.answer(MainActivity.this, "กรุณาตอบคำถาม");

        } else {

            checkTime();

        }

    }   //checkZero

    private void checkTime() {

        if (intIndex == 9) {

            Intent objIntent = new Intent(MainActivity.this, ShowScoreActivity.class);
            startActivity(objIntent);

        } else {

            //Show Controller Call View
            txtQuestion.setText(Integer.toString(intIndex + 2) + ". What is this ?");

            intIndex += 1;

            //Sent Value to MyModel
            objMyModel.setIntButton(intIndex + 1);

        }

    }   // checkTime


    private void bindWidget() {

        txtQuestion = (TextView) findViewById(R.id.textView2);
        imvIshihara = (ImageView) findViewById(R.id.imageView);
        ragChoice = (RadioGroup) findViewById(R.id.ragChoice);
        radChoice1 = (RadioButton) findViewById(R.id.radioButton);
        radChoice2 = (RadioButton) findViewById(R.id.radioButton2);
        radChoice3 = (RadioButton) findViewById(R.id.radioButton3);
        radChoice4 = (RadioButton) findViewById(R.id.radioButton4);
        btnAnswer = (Button) findViewById(R.id.button);

    }   // bindWidget


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
