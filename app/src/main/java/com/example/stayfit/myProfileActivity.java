package com.example.stayfit;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.codemybrainsout.ratingdialog.RatingDialog;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.File;

public class myProfileActivity extends AppCompatActivity {

    private static final String IMAGE_DIRECTORY = "/YourDirectName";
    private Context mContext;
    public static Drawable drawable=Drawable.createFromPath("R.drawable.ok");
    private File file;
    private TextView textUsername,AppVersionData;
    private ImageButton aboutUs,rateUs,shareApp;
    private Button calculateBmi,stepCounter,drinkWater,showNotification;
    private String m_Text="";
    CircularImageView circleImageView;
    private int GALLERY = 1, CAMERA = 2;
    boolean doubleBackToExitPressedOnce = false;
    //float x1,x2,y1,y2;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(myProfileActivity.this,Dashboard.class);
            startActivity(a);
            overridePendingTransition(0, 0);
            onPause();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        //Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        //calculateBmi=findViewById(R.id.calculateBMI);
        stepCounter=findViewById(R.id.stepCounter);
        //drinkWater=findViewById(R.id.drinkWater);
        showNotification=findViewById(R.id.notificationSetting);

        /*calculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(myProfileActivity.this,BMICalculator.class);
                startActivity(intent);
            }
        });*/
        stepCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(myProfileActivity.this,stepCount.class);
                startActivity(intent);
            }
        });

        /*drinkWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(myProfileActivity.this,BMICalculator.class);
//                startActivity(intent);
            }
        });*/

        showNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialogIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
            }
        });


        Context context=this;
        aboutUs = findViewById(R.id.aboutUs);
        rateUs = findViewById(R.id.rateUs);
        shareApp = findViewById(R.id.shareUs);
        AppVersionData = findViewById(R.id.AppVersionData);
        AppVersionData.setText("Version: "+BuildConfig.VERSION_NAME);


        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Element versionElement = new Element();
                versionElement.setTitle("Version "+BuildConfig.VERSION_NAME);*/

                /*View aboutPage = new AboutPage(getApplicationContext())
                        .isRTL(false)
                        .setCustomFont(" ") // or Typeface
                        .setImage(R.drawable.notification)
                        .addItem(versionElement)
                        .addGroup("Connect with us")
                        .addEmail("elmehdi.sakout@gmail.com")
                        .addWebsite("https://mehdisakout.com/")
                        .addFacebook("the.medy")
                        .addTwitter("medyo80")
                        .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                        .addPlayStore("com.ideashower.readitlater.pro")
                        .addGitHub("medyo")
                        .addInstagram("medyo80")
                        .create();*/
                Intent intent=new Intent(myProfileActivity.this,AboutUs.class);
                startActivity(intent);
            }
        });

        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RatingDialog ratingDialog = new RatingDialog.Builder(getApplicationContext())
                        .icon(drawable)
                        .session(7)
                        .threshold(3)
                        .title("How was your experience with us?")
                        .titleTextColor(R.color.black)
                        .positiveButtonText("Not Now")
                        .negativeButtonText("Never")
                        .positiveButtonTextColor(R.color.white)
                        .negativeButtonTextColor(R.color.grey_500)
                        .formTitle("Submit Feedback")
                        .formHint("Tell us where we can improve")
                        .formSubmitText("Submit")
                        .formCancelText("Cancel")
                        .ratingBarColor(R.color.yellow)
                        .playstoreUrl("YOUR_URL")
                        .onThresholdCleared(new RatingDialog.Builder.RatingThresholdClearedListener() {
                            @Override
                            public void onThresholdCleared(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                                //do something
                                ratingDialog.dismiss();
                            }
                        })
                        .onThresholdFailed(new RatingDialog.Builder.RatingThresholdFailedListener() {
                            @Override
                            public void onThresholdFailed(RatingDialog ratingDialog, float rating, boolean thresholdCleared) {
                                //do something
                                ratingDialog.dismiss();
                            }
                        })
                        .onRatingChanged(new RatingDialog.Builder.RatingDialogListener() {
                            @Override
                            public void onRatingSelected(float rating, boolean thresholdCleared) {

                            }
                        })
                        .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                            @Override
                            public void onFormSubmitted(String feedback) {

                            }
                        }).build();

                ratingDialog.show();
            }
        });

        //requestMultiplePermissions(); // check permission


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent b = new Intent(myProfileActivity.this,Dashboard.class);
                        startActivity(b);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_video:
                        Intent a = new Intent(myProfileActivity.this,FitnessVideosPlayer.class);
                        startActivity(a);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_image:
                        Intent c = new Intent(myProfileActivity.this,MotivationalImagesViewer.class);
                        startActivity(c);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_songs:
                        Intent d = new Intent(myProfileActivity.this,FitnessMusicPlayer.class);
                        startActivity(d);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.navigation_profile:
                        break;
                }
                return false;
            }
        });
    }
   /* private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {"Select photo from gallery", "Capture photo from camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY);
    }
    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(getApplicationContext(), "Image Saved!", Toast.LENGTH_SHORT).show();
                    circleImageView.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            circleImageView.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(getApplicationContext(), "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }
    private void showForgotDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Forgot Password")
                .setMessage("Enter your mobile number?")
                .setView(taskEditText)
                .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = String.valueOf(taskEditText.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }
    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        if (!wallpaperDirectory.exists()) {  // have the object build the directory structure, if needed.
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance().getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::---&gt;" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }



    private void requestMultiplePermissions() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {  // check if all permissions are granted
                            Toast.makeText(getApplicationContext(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
                        }

                        if (report.isAnyPermissionPermanentlyDenied()) { // check for permanent denial of any permission
                            // show alert dialog navigating to Settings
                            //openSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }

                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }*/
}