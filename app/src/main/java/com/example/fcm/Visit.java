package com.example.fcm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Visit extends AppCompatActivity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_people_outline_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_visit);
        text = (TextView) findViewById(R.id.txt);
        parseXML();
    }

    private void parseXML() {
        //gaining access to the XMLpullparser afactory
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("data.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);

            parser.setInput(is, null);
            processParsing(parser);

        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }

    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        //PARSING THE USER XML DEFINED Data and displying it in a list format
        //
        ArrayList<Patients> patients = new ArrayList<>();
        int eventType = parser.getEventType();
        Patients currentPatient = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltname=null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltname = parser.getName();
                    if ("patient".equals(eltname)) {
                        currentPatient = new Patients();
                        patients.add(currentPatient);
                    } else if (currentPatient != null) {
                        if ("name".equals(eltname)) {
                            currentPatient.name = parser.nextText();
                        } else if ("age".equals(eltname)) {
                            currentPatient.age = parser.nextText();
                        } else if ("location".equals(eltname)) {
                            currentPatient.location = parser.nextText();
                        }

                    }
                    break;
            }
            eventType = parser.next();
        }
        printPatient(patients);
    }

    private void printPatient(ArrayList<Patients> patients) {
        StringBuilder builder = new StringBuilder();
        for (Patients patient : patients) {
            builder.append(patient.name).append("\n").append(patient.age).
                    append("\n").
                    append(patient.location).append("\n\n");
        }
        text.setText(builder.toString());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int a = item.getItemId();
        switch (a) {
            case R.id.find:
                Intent myintent1 = new Intent(Visit.this, Find.class);
                startActivity(myintent1);
                break;
            case R.id.vist:
                Intent myintent2 = new Intent(Visit.this, Visit.class);
                startActivity(myintent2);
                break;
            case R.id.contact:
                Intent myintent4 = new Intent(Visit.this, Notification.class);
                startActivity(myintent4);
                break;

            default:
                return false;

        }

        return super.onOptionsItemSelected(item);
    }
}

