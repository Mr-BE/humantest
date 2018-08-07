package codeblaq.humantest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables for EditText fields
    EditText riverEditText;
    String riverText;
    EditText usernameET;
    String userName;

    //Values for answers
    int twinAnswer;
    int rangeAnswer;
    int worldWarAnswer;
    int waterBodyAnswer;
    int satelliteAnswer;
    int desertAnswer;
    int deepestPointAnswer;
    int populousAnswer;
    int riverAnswer;
    int nukeAnswer;
    /*
    Radio Buttons and groups
     */
    private RadioGroup earthTwinRg;
    private  RadioGroup mountainRangeRg;
    private  RadioGroup desertRadioGroup;
    private  RadioGroup deepestPointRg;
    private RadioGroup populousRadioGroup;
    private RadioGroup waterBodyRg;
    private RadioGroup satelliteRg;
    private RadioGroup worldWarRg;
    private RadioButton planetRadioButton;
    private RadioButton rangeRadioButton;
    private RadioButton desertRadioButton;
    private RadioButton deepPointRadioButton;
    private RadioButton populousRadioButton;
    private RadioButton waterBodyRadioButton;
    private RadioButton satelliteRadioButton;
    private RadioButton worldWarRadioButton;

    /*
    IDs gotten from Radio buttons in Radio groups
     */
    int selectedPlanetID;
    int selectedRangeId;
    int selectedDesertId;
    int selectedDeepestPointId;
    int selectPopulousId;
    int selectedWaterBodyId;
    int selectedSatelliteId;
    int selectedWorldWarId;
    /*
    CheckBoxes
     */
    private CheckBox usaNukeCheckbox;
    private CheckBox dprkNukeCheckbox;
    private CheckBox russiaNukeCheckbox;
    private CheckBox japanNukeCheckbox;
    private  CheckBox aiCheckBox;

    // String values for results
    String score;
    String message;

    /*
    Linear layout values
     */

    LinearLayout twinQ;
    LinearLayout waterQ;
    LinearLayout worldWarQ;
    LinearLayout nukeQ;
    LinearLayout desertQ;
    LinearLayout deepestQ;
    LinearLayout rangeQ;
    LinearLayout populousQ;
    LinearLayout satelliteQ;
    LinearLayout riverQ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Method for when submit button is clicked
    public void submit(View view) {

        //Toast items for results
        Context context = getApplicationContext();
        int durationShort = Toast.LENGTH_SHORT;
        int durationLong = Toast.LENGTH_LONG;

        /**
         * Setup Radio button checks
         */
        //Locate twin planet Radio Group
        earthTwinRg = findViewById(R.id.earth_twin_RG);
        //Get selected radio button ID from group
        selectedPlanetID = earthTwinRg.getCheckedRadioButtonId();
        //Determine which button was selected by ID
        planetRadioButton = findViewById(selectedPlanetID);

        //Locate Mountain range radio group
        mountainRangeRg = findViewById(R.id.mountain_range_RG);
        //Get selected radio button Id from
        selectedRangeId = mountainRangeRg.getCheckedRadioButtonId();
        //Determine selected button by Id
        rangeRadioButton = findViewById(selectedRangeId);

        //Locate Desert range Radio Group
         desertRadioGroup = findViewById(R.id.desert_RG);
        //Get selected radio button Id from group
        selectedDesertId = desertRadioGroup.getCheckedRadioButtonId();
        desertRadioButton = findViewById(selectedDesertId);

        //Locate Deepest point radio group
         deepestPointRg = findViewById(R.id.deepest_point_RG);
        //Get selected radio button Id from group
       selectedDeepestPointId = deepestPointRg.getCheckedRadioButtonId();
        deepPointRadioButton = findViewById(selectedDeepestPointId);

        //Locate most populous radio group
        populousRadioGroup = findViewById(R.id.populous_RG);
        //Get selected radio button Id from group
        selectPopulousId = populousRadioGroup.getCheckedRadioButtonId();
        populousRadioButton = findViewById(selectPopulousId);

        //Locate water body Radio Group
        waterBodyRg = findViewById(R.id.water_body_RG);
        //Get selected radio button Id from group
        selectedWaterBodyId = waterBodyRg.getCheckedRadioButtonId();
        waterBodyRadioButton = findViewById(selectedWaterBodyId);
//
        //Locate satellite Radio Group
        satelliteRg = findViewById(R.id.satellite_RG);
        //Get selected radio button Id from group
        selectedSatelliteId = satelliteRg.getCheckedRadioButtonId();
        satelliteRadioButton = findViewById(selectedSatelliteId);

        //Locate World war Radio Group
        worldWarRg = findViewById(R.id.world_war_RG);
        //Get selected radio button Id from group
        selectedWorldWarId = worldWarRg.getCheckedRadioButtonId();
        worldWarRadioButton = findViewById(selectedWorldWarId);

        //Locate username EditText field
         usernameET = findViewById(R.id.username);
        //Get text from user input
        userName = usernameET.getText().toString();

        //Locate AI check CheckBox
        aiCheckBox = findViewById(R.id.aiCheckBox);
        //Set up boolean for checked state
        boolean isNotRobot = aiCheckBox.isChecked();

        /**
         * Answer values gotten from question methods
         */
        //Get value of answer from worldwar radio group
        int worldWarValue = getWorldWarAnswer();

        //Get value of answer from waterBody RadioGroup
        int waterBodyValue = getWaterBodyAnswer();

        //Get value of answer from planet RadioGroup
        int twinValue = getEarthTwinAnswer();

        //Get value of answer from range radio group
        int rangeValue = getRangeAnswer();

        //Get value of answer from satellite radio group
        int satelliteValue = getSatelliteAnswer();

        //Get value of answer from desert radio group
        int desertValue = getDesertAnswer();

        //Get value of answer from deepest point radio group
        int deepestPointValue = getDeepestPointAnswer();

        //Get value of answer from populous point radio group
        int populousValue = getPopulousAnswer();

        //Get value of answer from river EditText
        int riverValue = getRiverAnswer();

        //Get value of answer from nuke Checkboxes
        int nukeValue = getNukeAnswer();

        //Calculate user's total score
        int totalScore = calculateScore(waterBodyValue,twinValue,riverValue,deepestPointValue,desertValue,
                populousValue,nukeValue,satelliteValue,rangeValue,worldWarValue);
        //Score messages
        String perfectMessage = "Congrats on a perfect score.\nYou're 100% human.";
        String nextBestMessage = "You're human but probably descended from an ancient alien race.";
        String middleMessage = "A weak alien presence has been detected, monitoring needed.";
        String poorMessage = "A strong alien presence has been detected, review needed.";
        String badMessage = "Alert!\nAlien detected!!!";

        //If user has not inputted a username
        if (userName.isEmpty()){
            String usernameWarning = "Please input a name";
            Toast.makeText(context,usernameWarning,durationShort).show();
        }
        else {
            //If AI checkbox is checked, begin calculating results
            if (isNotRobot) {

                //User with perfect score of 10
                if (totalScore == 10) {
                    message = "Dear " + userName + ",\n" + "Your scored 10 out of 10\n" + perfectMessage;
                    //Display result as a toast
                    Toast.makeText(context, message, durationLong).show();

                }
                //User with next best score of 9, 8 or 7
                if (totalScore == 9 || totalScore == 8 || totalScore == 7) {
                    //Convert score value to string
                    score = ((Integer) totalScore).toString();
                    message = "Dear " + userName + ",\n" + "You scored " + score + " out of 10\n" + nextBestMessage;
                    //Display result as a toast
                    Toast.makeText(context, message, durationLong).show();
                }
                //User with middle scores of 6 or 5
                if (totalScore == 6 || totalScore == 5) {
                    //Convert score to string value
                    score = ((Integer) totalScore).toString();
                    message = userName + ",\n" + "You scored " + score + " out of 10\n" + middleMessage;
                    //Display result as a toast
                    Toast.makeText(context, message, durationLong).show();
                }
                //User with poor score of 4 or 3
                if (totalScore == 4 || totalScore == 3) {
                    //Convert score to string
                    score = ((Integer) totalScore).toString();
                    message = userName + ",\n" + "You scored " + score + " out of 10\n" + poorMessage;
                    //Display result as a toast
                    Toast.makeText(context, message, durationLong).show();
                }
                //User with bad score of 2, 1 or 0
                if (totalScore == 2 || totalScore == 1 || totalScore == 0) {
                    //Convert score to string
                    score = ((Integer) totalScore).toString();
                    message = userName + ",\n" + "You scored " + score + " out of 10\n" + badMessage;
                    //Display result as a toast
                    Toast.makeText(context, message, durationLong).show();
                }
            }
            //AI checkbox left unchecked
            else {
                String aIMessage = "Sorry, no robots or AI allowed";
                Toast.makeText(context, aIMessage, durationShort).show();
            }
        }

        /*
        Color highlights for wrong answers
         */

        //If answer value is wrong
        if (twinValue == 0) {
            twinQ = findViewById(R.id.twinQ);
            twinQ.setBackgroundColor(Color.RED);
        }

        if (waterBodyValue == 0) {
            waterQ = findViewById(R.id.waterBodyQ);
            waterQ.setBackgroundColor(Color.RED);
        }
        if (worldWarValue == 0) {
            worldWarQ = findViewById(R.id.worldWarQ);
            worldWarQ.setBackgroundColor(Color.RED);
        }
        if (nukeValue == 0) {
            nukeQ = findViewById(R.id.nukeQ);
            nukeQ.setBackgroundColor(Color.RED);
        }
        if (desertValue == 0) {
            desertQ = findViewById(R.id.desertQ);
            desertQ.setBackgroundColor(Color.RED);
        }
        if (deepestPointValue == 0) {
            deepestQ = findViewById(R.id.deepPointQ);
            deepestQ.setBackgroundColor(Color.RED);
        }
        if (rangeValue == 0) {
            rangeQ = findViewById(R.id.highestRangeQ);
            rangeQ.setBackgroundColor(Color.RED);
        }
        if (populousValue == 0) {
            populousQ = findViewById(R.id.mostPoplousQ);
            populousQ.setBackgroundColor(Color.RED);
        }
        if (satelliteValue == 0) {
            satelliteQ = findViewById(R.id.satelliteQ);
            satelliteQ.setBackgroundColor(Color.RED);
        }
        if (riverValue == 0) {
            riverQ = findViewById(R.id.longRiverQ);
            riverQ.setBackgroundColor(Color.RED);
        }

    }


    /**
     * Method for the reset button
     */
    public void reset (View view){
        Context context = getApplicationContext();
        String warning = "Please complete test first";
        int duration = Toast.LENGTH_SHORT;

        //Reset radio buttons but ensure that they radio buttons have been checked first
        //Ensure that Id gotten from radio group is not 0 before attempting reset
        if (selectedPlanetID != 0) {
            earthTwinRg.clearCheck();
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (selectedWorldWarId!= 0) {
            worldWarRg.clearCheck();
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (selectedRangeId !=0) {
            mountainRangeRg.clearCheck();
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (selectedWaterBodyId !=0) {
            waterBodyRg.clearCheck();
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (selectedSatelliteId != 0) {
            satelliteRg.clearCheck();
        }
        if (selectedDeepestPointId !=0 ) {
            deepestPointRg.clearCheck();
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (selectedDesertId != 0) {
            desertRadioGroup.clearCheck();
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (selectPopulousId !=0) {
            populousRadioGroup.clearCheck();

        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        //Reset check boxes
        if (usaNukeCheckbox!= null){
            usaNukeCheckbox.setChecked(false);
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (dprkNukeCheckbox!= null){
            dprkNukeCheckbox.setChecked(false);
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (russiaNukeCheckbox!= null){
            russiaNukeCheckbox.setChecked(false);
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (japanNukeCheckbox!= null){
            japanNukeCheckbox.setChecked(false);
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        if (aiCheckBox!= null){
            aiCheckBox.setChecked(false);
        }
        else {
            Toast.makeText(context,warning,duration).show();
        }
        //Reset EditText fields checking first that the field is not empty
        if (userName== null){
            Toast.makeText(context,warning,duration).show();
        }
        else {
            usernameET.setText("");
        }
    if (riverText== null){
        Toast.makeText(context,warning,duration).show();
    }
    else {
        riverEditText.setText("");

        }

        /*
        Reset background color
         */
        twinQ = findViewById(R.id.twinQ);
        twinQ.setBackgroundResource(R.drawable.my_background);

        waterQ = findViewById(R.id.waterBodyQ);
        waterQ.setBackgroundResource(R.drawable.my_background);

        desertQ = findViewById(R.id.desertQ);
        desertQ.setBackgroundResource(R.drawable.my_background);

        riverQ = findViewById(R.id.longRiverQ);
        riverQ.setBackgroundResource(R.drawable.my_background);

        rangeQ = findViewById(R.id.highestRangeQ);
        rangeQ.setBackgroundResource(R.drawable.my_background);

        nukeQ = findViewById(R.id.nukeQ);
        nukeQ.setBackgroundResource(R.drawable.my_background);

        worldWarQ = findViewById(R.id.worldWarQ);
        worldWarQ.setBackgroundResource(R.drawable.my_background);

        satelliteQ = findViewById(R.id.satelliteQ);
        satelliteQ.setBackgroundResource(R.drawable.my_background);

        populousQ = findViewById(R.id.mostPoplousQ);
        populousQ.setBackgroundResource(R.drawable.my_background);

        deepestQ = findViewById(R.id.deepPointQ);
        deepestQ.setBackgroundResource(R.drawable.my_background);
    }
    /**
     * Method for the share button
     */
    public void share (View view){
        Context context = getApplicationContext();
        String warning = "Please complete test first";
        int duration = Toast.LENGTH_SHORT;

        //User has not done test
        if (message != null) {

            //Create Intent
            Intent sharingIntent = new Intent();
            sharingIntent.setAction(Intent.ACTION_SEND);
            //Set intent sharing type (general type)
            sharingIntent.setType("text/plain");
            //Intent content message
            String intentContent = message;
            //Subject of shared message
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "My Human test results");
            //Message content
            sharingIntent.putExtra(Intent.EXTRA_TEXT, intentContent);
            //Start Intent
            startActivity(sharingIntent);

        } else {
            Toast.makeText(context, warning, duration).show();

        }
    }


    /**
     * Method to calculate user score
     * @param twin is value of twin answer
     * @param water is the value of water answer
     * @param river is the value of river answer
     * @param deep is the value of deepest point anser
     * @param desert is value of desert answer
     * @param populous is value of populous answer
     * @param nuke is value of nuke answer
     * @param satellite is value of Satellite answer
     * @param range is value of range answer
     * @param war is value of war answer
     * @return total score
     */
    private int calculateScore(int twin, int water, int river,
                               int deep, int desert,int populous,
                               int nuke, int satellite, int range,
                               int war) {
        int score = twin+ water+ range+river + deep + desert + populous+ nuke+
                satellite + war;
        return score;
    }



    /**
     * Method to check user's answer for the question on Earth's twin
     *
     * @return numeric value assigned to either right or wrong respectively
     */
    private int getEarthTwinAnswer() {
        //Check if radio button has been selected
        if (planetRadioButton != null) { //User has selected an option

            //Store text gotten from selected option
            String planetText = planetRadioButton.getText().toString();

            //Get text from selected radio button and compare to answer text
            if (planetText.equals("Venus")) { // Correct option
                twinAnswer = 1;
            } else { // Any other selected option is wrong
                twinAnswer = 0;
            }

        } else {
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();

        }
        return twinAnswer;

    }

    /**
     * Method to validate user's answer on World War question
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong respectively
     */
    private int getWorldWarAnswer() {
        //Check if radio button has been checked
        if (worldWarRadioButton != null) { //Question has been answered

            //Get text from selected radio button and compare to answer text
            String worldWarText = worldWarRadioButton.getText().toString();
            if (worldWarText.equals("Germany")) { //Correct
                worldWarAnswer = 1;
            } else { //wrong
                worldWarAnswer = 0;
            }
        } else { //No answer selected
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();

        }
        return worldWarAnswer;

    }


    /**
     * Method to determine user's answer for mountain range question
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */


    private int getRangeAnswer() {
        //Check if question has been answered
        if (rangeRadioButton != null) { //Question answered

            //Get text from selected radio button and compare to answer text
            String rangeText = rangeRadioButton.getText().toString();

            if (rangeText.equals("Himalayas")) { //Correct answer
                rangeAnswer = 1;
            } else { //wrong answer
                rangeAnswer = 0;
            }
        } else { //No answer
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();

        }
        return rangeAnswer;
    }

    /**
     * Method to get user's answer on the water body question
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */
    private int getWaterBodyAnswer() {
        //Check if question has been answered
        if (waterBodyRadioButton != null) { //Question answered

            //Get text from selected radio button and compare to answer text
            String waterBodyText = waterBodyRadioButton.getText().toString();

            if (waterBodyText.equalsIgnoreCase("Pacific Ocean")) { // correct option

                waterBodyAnswer = 1;

            } else { //wrong option
                waterBodyAnswer = 0;
            }
        } else {
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();

        }
        return waterBodyAnswer;
    }

    /**
     * Method to get the user's answer for Satellite question
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */
    private int getSatelliteAnswer() {
        //Check if question has been answered

        if (satelliteRadioButton != null) {//Answer given

            //Get text from selected radio button and compare to answer text
            String satelliteText = satelliteRadioButton.getText().toString();
            if (satelliteText.equals("Russia")) { //correct
                satelliteAnswer = 1;
            } else { //Wrong
                satelliteAnswer = 0;
            }
        } else { //Question not answered
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();

        }
        return satelliteAnswer;
    }

    /**
     * Method for getting answer for the Desert question
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */
    private int getDesertAnswer() {
        //Check if question has been answered
        if (desertRadioButton != null) { //Question answered

            //Get text from selected radio button and compare to answer text
            String desertText = desertRadioButton.getText().toString();

            if (desertText.equals("Atacama")) { //correct
                desertAnswer = 1;
            } else { //wrong
                desertAnswer = 0;
            }
        } else { //Not answered
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();

        }
        return desertAnswer;
    }

    /**
     * Method to get answer from deepest point question
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */
    private int getDeepestPointAnswer() {
        //Check if question has been answered
        if (deepPointRadioButton != null) { //Question answered

            //Get text from selected radio button and compare to answer text
            String deepestPointText = deepPointRadioButton.getText().toString();


            if (deepestPointText.equals("Mariana Trench")) { // correct option selected
                deepestPointAnswer = 1;
            } else { //wrong option selected
                deepestPointAnswer = 0;
            }
        } else { //Question unanswered
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();
        }
        return deepestPointAnswer;
    }

    /**
     * Method to get answer from 2nd most populous country answer
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */

    private int getPopulousAnswer() {
        //Check if this question has been answered
        if (populousRadioButton != null) { // Question answered

            //Get text from selected radio button and compare to answer text
            String populousText = populousRadioButton.getText().toString();

            if (populousText.equals("India")) { //Correct option selected
                populousAnswer = 1;
            } else { // Wrong option
                populousAnswer = 0;
            }
        } else {
            String warningMessage = "Please complete all fields";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            Toast.makeText(context, warningMessage, duration).show();

        }
        return populousAnswer;
    }

    /**
     * Method to get answer from river question
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */
    private int getRiverAnswer() {


        //Locate EditText field for river question
        riverEditText = findViewById(R.id.river_answer_ET);
        //Get inputted text
        riverText = riverEditText.getText().toString();

        //Possible correct answers
        String nile = "Nile";
        String riverNile = "River Nile";


        //Things for Toast message
        Context context = getApplicationContext();
        String riverWarning = "Please complete all fields";
        int duration = Toast.LENGTH_SHORT;

        //Peradventure user mistakenly skips this question
        if (riverText.isEmpty()) {
            Toast.makeText(context, riverWarning, duration).show();


        } else {
            //Check if user's answers match the possible correct answers
            if (riverText.equalsIgnoreCase(nile) || riverText.equalsIgnoreCase(riverNile)) {
                riverAnswer = 1;
            } else {
                riverAnswer = 0;
            }
        }
        return riverAnswer;
    }

    /**
     * Get answer from the Nuclear (nuke) radio group
     *
     * @return assigned numeric value 1 or 0 to selected value to signify right or wrong
     */
    private int getNukeAnswer() {
        //Toast things
        String warningMessage = "Please complete all fields";
        String numberExceeded = "Select only two options for Question 8";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        /**
         * Set up checkboxes for this question
         */
        //Find Usa checkbox
        usaNukeCheckbox = findViewById(R.id.usa_nuke_CB);
        //Set up state for when checkbox is checked
        boolean isUsa = usaNukeCheckbox.isChecked();


        //Find DPRK checkbox
        dprkNukeCheckbox = findViewById(R.id.north_korea_nuke_CB);
        //Set up state for when checkbox is checked
        boolean isNorthKorea = dprkNukeCheckbox.isChecked();

        //Find Russia checkbox
        russiaNukeCheckbox = findViewById(R.id.russia_nuke_CB);
        //Set up state for when checkbox is checked
        boolean isRussia = russiaNukeCheckbox.isChecked();

        //Find Japan checkbox
         japanNukeCheckbox = findViewById(R.id.japan_nuke_CB);
        //Set up state for when checkbox is checked
        boolean isJapan = japanNukeCheckbox.isChecked();

        /**
         * Check user selection
         */

        //Ensure that this question is only marked as correct when the user selects the two correct answers
        if (isUsa && isJapan) {
            nukeAnswer = 1;
        } else {
            nukeAnswer = 0;
        }
        if (isJapan && isNorthKorea && isRussia && isUsa //All options selected
                ) {
            Toast.makeText(context, numberExceeded, duration).show();

        }
        return nukeAnswer;
    }


}
