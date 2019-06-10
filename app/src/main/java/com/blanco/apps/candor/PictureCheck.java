package com.blanco.apps.candor;


import android.content.Intent;
import android.graphics.Picture;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureCheck extends Fragment implements View.OnClickListener {


  /*  public PictureCheck() {
        // Required empty public constructor
    }*/

/*
    private TextInputLayout textInputLocation;
    private ImageView picHolder;
    private Button submitButton;
    private Button locationButton;*/

    private ImageView image;
    private Button button;
    public String check;
    ArrayList<String> d = new ArrayList<>();
    private Uri imageUri;
    private TextView textView,textView2;
    private static  final int pick_image = 100;

    String myAttribute = "Exif information ---\n";

    private void openGallary() {
        Intent gallary=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallary,pick_image);
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==pick_image && resultCode==RESULT_OK){
            imageUri=data.getData();
            image.setImageURI(imageUri);
            test2(imageUri);

        }

    }


    private void test2(Uri uri)
    {
        //  Uri uri; // the URI you've received from the other app
        InputStream in = null;
        //String myAttribute = "";
        try {
            in = getActivity().getContentResolver().openInputStream(uri);
            ExifInterface exifInterface = new ExifInterface(in);

           test(exifInterface);
            //myAttribute += getTagString(ExifInterface., exifInterface);


           // textView.setText(myAttribute);



            //textView2.setText(value);
            //System.out.println(myAttribute);

            Log.d("cheeec me", myAttribute);
            Log.d("new check",value);
            // Now you can extract any Exif tag you want
            // Assuming the image is a JPEG or supported raw format
        } catch (IOException e) {
            // Handle any errors
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignored) {
                    Log.d("exception","this is ex");
                }
            }
        }
    }
    String value = "";
    String value1 = "";
    String value2 = "";
    private ArrayList<String> test(ExifInterface exif )
    {
     d.clear();
      //  HashMap<String,Integer> hi=new HashMap<>();
        value1 = getTagString(ExifInterface.TAG_DATETIME_ORIGINAL, exif);
        value2 = getTagString(ExifInterface.TAG_DATETIME_DIGITIZED, exif);
        value = getTagString(ExifInterface.TAG_DATETIME, exif);

        value += getTagString(ExifInterface.TAG_SOFTWARE,exif);
        value += getTagString(ExifInterface.TAG_ARTIST,exif);
        value += getTagString(ExifInterface.TAG_DEFAULT_CROP_SIZE,exif);
        value += getTagString(ExifInterface.TAG_GPS_ALTITUDE,exif);
        value += getTagString(ExifInterface.TAG_GPS_DATESTAMP,exif);
        value += getTagString(ExifInterface.TAG_GPS_AREA_INFORMATION,exif);
        value += getTagString(ExifInterface.TAG_GPS_ALTITUDE_REF,exif);
        value += getTagString(ExifInterface.TAG_GPS_TRACK,exif);
        value += getTagString(ExifInterface.TAG_MODEL,exif);
        value += getTagString(ExifInterface.TAG_GPS_DEST_BEARING_REF,exif);



        myAttribute += getTagString(ExifInterface.TAG_DATETIME, exif);
        myAttribute += getTagString(ExifInterface.TAG_FLASH, exif);
        myAttribute += getTagString(ExifInterface.TAG_GPS_LATITUDE, exif);
        myAttribute += getTagString(ExifInterface.TAG_GPS_LATITUDE_REF, exif);

        myAttribute += getTagString(ExifInterface.TAG_GPS_LONGITUDE, exif);
        myAttribute += getTagString(ExifInterface.TAG_GPS_LONGITUDE_REF, exif);
        myAttribute += getTagString(ExifInterface.TAG_IMAGE_LENGTH, exif);
        myAttribute += getTagString(ExifInterface.TAG_IMAGE_WIDTH, exif);
        myAttribute += getTagString(ExifInterface.TAG_MAKE, exif);
        myAttribute += getTagString(ExifInterface.TAG_MODEL, exif);
        myAttribute += getTagString(ExifInterface.TAG_ORIENTATION, exif);
        myAttribute += getTagString(ExifInterface.TAG_WHITE_BALANCE, exif);
        d.add(""+checkDate(getTagString(ExifInterface.TAG_DATETIME_ORIGINAL, exif),getTagString(ExifInterface.TAG_DATETIME_DIGITIZED, exif),getTagString(ExifInterface.TAG_DATETIME, exif)));
//

        d.add("1");
        d.add("1");
        d.add("1");
        d.add("1");
//
//        textView.setText(myAttribute);
        return d;
    }


    private String getTagString(String tag, ExifInterface exif)
    {
        return(exif.getAttribute(tag));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_picture_check, container, false);



    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        /*picHolder=getView().findViewById(R.id.image_holder);
        submitButton=getView().findViewById(R.id.submit_btn);
*/
        image= getView().findViewById(R.id.image_holder);
        button=getView().findViewById(R.id.submit_btn);
           textView = getView().findViewById(R.id.lass);
        textView2 = getView().findViewById(R.id.fail);



        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallary();
                //textView.setText(myAttribute);


            }
        });

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent i = new Intent(getContext(),ResultActivity.class);
//            i.putExtra("check",check);
//            i.putExtra("image", (Serializable) image);
//            startActivity(i);

//            Log.d("value1", value1);
            //Log.d("value2",value2);
           // System.out.println(value2);
    if(checkDate(value1,value2,value) == 0){
            textView.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
//        textView2.setText("False");
    }
    else
    {
//        textView2.setText("True");
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.INVISIBLE);
    }
        }
    });
    }


    @Override
    public void onClick(View v) {
       /* switch (v.getId()){
            case (R.id.image_holder):{
                openGallary();
                System.out.println("hello");
                Log.d("image ","workdsssssssssssssss");
                //TODO: browse image code
                break;}

            case (R.id.submit_btn):{
                //TODO: check if valid
                System.out.println("hiiii");
                Log.d("submit","worksssssssssssss");
                //  Toast.makeText(this,"this i the message",Toast.LENGTH_LONG).show();
                break;}
            case (R.id.pickLocation): {
                System.out.println("On your way!");
                Log.d("location","Wrokssssssss");
            }*/
        }





//    int num= checkDate(getTagString(ExifInterface.TAG_DATETIME_ORIGINAL, exifInterface),getTagString(ExifInterface.TAG_DATETIME_DIGITIZED, exifInterface), getTagString(ExifInterface.TAG_DATETIME, exifInterface));
//            if(num==0){
//        textView.setText("doesn't");
//    }else if(num==1){
//        textView.setText("works");
//    }

    public int checkDate(String dateOriginal,String dateModified, String dateTime){
        if(dateModified==null || dateModified==null){
            return 0;

        }
        else if(dateModified!=null &&  dateTime!=null && dateOriginal != null )
        {
            return 1;
        }
        else{
            return 0;
        }

    }



    public int checkLocation(LatLng location, LatLng current){
        // Location location2 =new Location("");
        // location2.setLatitude(location.latitude);
        // location2.setLongitude(location.longitude);
        float[] distance =new float[1];
        Location.distanceBetween(location.latitude,location.longitude,current.latitude,current.longitude,distance);

        if(distance[0] < 400)
        {
            return 1;
        }
        else{
            return 0;
        }

    }
    public LatLng changetoLocation(String latitude,String longitude){
        Double latitude1=Double.parseDouble(latitude);
        Double longitude1=Double.parseDouble(longitude);
        LatLng location=new LatLng(latitude1,longitude1);

        return location;
    }
    }







