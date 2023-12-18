import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlantManager {
    private static ArrayList<ArrayList<Double>> plantFactors;
    private static ArrayList<Double> americanPlumFactors;
    private static ArrayList<Double> blueStemFactors;
    private static ArrayList<Double> commonMilkWeedFactors;
    private static ArrayList<Double> easternBottleBrushGrassFactors;
    private static ArrayList<Double> goldenRodFactors;
    private static ArrayList<Double> leadPlantFactors;
    private static ArrayList<Double> shagBarkHickoryFactors;
    private static ArrayList<Double> stJohnWortFactors;
    private static ArrayList<Double> sumacFactors;
    private static ArrayList<Double> tallMeadowRueFactors;
    private int numAmericanPlum;
    private int numBlueStem;
    private int numMilkWeed;
    private int numBottleBrush;
    private int numBlueStem2;
    private int numGoldenRod;
    private int numLeadplant;
    private int numShagBarkHickory;
    private int numStJohnsWort;
    private int numSumac;
    private int numTallMeadowRue;

    public PlantManager() {
        plantFactors = new ArrayList<ArrayList<Double>>();

        americanPlumFactors = new ArrayList<Double>();
        americanPlumFactors.add(30.0); // ideal water in mm
        americanPlumFactors.add(6.0); // ideal sun in hours
        americanPlumFactors.add(60.0); // ideal Nitrogen in ppm
        americanPlumFactors.add(60.0); // ideal Phosphorous in ppm
        americanPlumFactors.add(60.0); // ideal Potassium in ppm
        americanPlumFactors.add(485.0); // ideal Calcium in ppm
        americanPlumFactors.add(50.0); // ideal Magnesium in ppm
        americanPlumFactors.add(15.0); // ideal Sulpur in ppm
        americanPlumFactors.add(1.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        americanPlumFactors.add(1.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        americanPlumFactors.add(90.0); // number of days to grow under ideal conditions)
        plantFactors.add(americanPlumFactors);

        blueStemFactors = new ArrayList<Double>();
        blueStemFactors.add(20.0); // ideal water in mm
        blueStemFactors.add(6.0); // ideal sun in hours
        blueStemFactors.add(50.0); // ideal Nitrogen in ppm
        blueStemFactors.add(50.0);  // ideal Phosphorous in ppm
        blueStemFactors.add(60.0); // ideal Potassium in ppm
        blueStemFactors.add(485.0); // ideal Calcium in ppm
        blueStemFactors.add(50.0); // ideal Magnesium in ppm
        blueStemFactors.add(15.0); // ideal Sulpur in ppm
        blueStemFactors.add(1.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        blueStemFactors.add(1.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        blueStemFactors.add(20.0); // number of days to grow under ideal conditions)
        plantFactors.add(blueStemFactors);

        commonMilkWeedFactors = new ArrayList<Double>(); // fixes nitrogen
        commonMilkWeedFactors.add(30.0); // ideal water in mm
        commonMilkWeedFactors.add(7.0); // ideal sun in hours
        commonMilkWeedFactors.add(50.0); // ideal Nitrogen in ppm
        commonMilkWeedFactors.add(50.0);  // ideal Phosphorous in ppm
        commonMilkWeedFactors.add(60.0); // ideal Potassium in ppm
        commonMilkWeedFactors.add(485.0); // ideal Calcium in ppm
        commonMilkWeedFactors.add(50.0); // ideal Magnesium in ppm
        commonMilkWeedFactors.add(15.0); // ideal Sulpur in ppm
        commonMilkWeedFactors.add(0.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        commonMilkWeedFactors.add(2.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        commonMilkWeedFactors.add(30.0); // number of days to grow under ideal conditions)
        plantFactors.add(commonMilkWeedFactors);

        easternBottleBrushGrassFactors = new ArrayList<Double>();
        easternBottleBrushGrassFactors.add(22.0); // ideal water in mm
        easternBottleBrushGrassFactors.add(6.0); // ideal sun in hours
        easternBottleBrushGrassFactors.add(50.0); // ideal Nitrogen in ppm
        easternBottleBrushGrassFactors.add(50.0);  // ideal Phosphorous in ppm
        easternBottleBrushGrassFactors.add(60.0); // ideal Potassium in ppm
        easternBottleBrushGrassFactors.add(480.0); // ideal Calcium in ppm
        easternBottleBrushGrassFactors.add(50.0); // ideal Magnesium in ppm
        easternBottleBrushGrassFactors.add(15.0); // ideal Sulpur in ppm
        easternBottleBrushGrassFactors.add(2.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        easternBottleBrushGrassFactors.add(0.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        easternBottleBrushGrassFactors.add(20.0); // number of days to grow under ideal conditions)
        plantFactors.add(easternBottleBrushGrassFactors);

        goldenRodFactors = new ArrayList<Double>(); // fixes nitrogen
        goldenRodFactors.add(28.0); // ideal water in mm
        goldenRodFactors.add(6.0); // ideal sun in hours
        goldenRodFactors.add(55.0); // ideal Nitrogen in ppm
        goldenRodFactors.add(55.0);  // ideal Phosphorous in ppm
        goldenRodFactors.add(55.0); // ideal Potassium in ppm
        goldenRodFactors.add(480.0); // ideal Calcium in ppm
        goldenRodFactors.add(50.0); // ideal Magnesium in ppm
        goldenRodFactors.add(15.0); // ideal Sulpur in ppm
        goldenRodFactors.add(0.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        goldenRodFactors.add(2.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        goldenRodFactors.add(40.0); // number of days to grow under ideal conditions)
        plantFactors.add(goldenRodFactors);
       
        leadPlantFactors = new ArrayList<Double>(); // fixes nitrogen
        leadPlantFactors.add(20.0); // ideal water in mm
        leadPlantFactors.add(6.0); // ideal sun in hours
        leadPlantFactors.add(60.0); // ideal Nitrogen in ppm
        leadPlantFactors.add(60.0);  // ideal Phosphorous in ppm
        leadPlantFactors.add(60.0); // ideal Potassium in ppm
        leadPlantFactors.add(485.0); // ideal Calcium in ppm
        leadPlantFactors.add(50.0); // ideal Magnesium in ppm
        leadPlantFactors.add(13.0); // ideal Sulpur in ppm
        leadPlantFactors.add(1.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        leadPlantFactors.add(1.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        leadPlantFactors.add(50.0); // number of days to grow under ideal conditions)
        plantFactors.add(leadPlantFactors);

        shagBarkHickoryFactors = new ArrayList<Double>();
        shagBarkHickoryFactors.add(23.0); // ideal water in mm
        shagBarkHickoryFactors.add(7.0); // ideal sun in hours
        shagBarkHickoryFactors.add(45.0); // ideal Nitrogen in ppm
        shagBarkHickoryFactors.add(45.0);  // ideal Phosphorous in ppm
        shagBarkHickoryFactors.add(45.0); // ideal Potassium in ppm
        shagBarkHickoryFactors.add(480.0); // ideal Calcium in ppm
        shagBarkHickoryFactors.add(50.0); // ideal Magnesium in ppm
        shagBarkHickoryFactors.add(15.0); // ideal Sulpur in ppm
        shagBarkHickoryFactors.add(0.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        shagBarkHickoryFactors.add(2.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        shagBarkHickoryFactors.add(90.0); // number of days to grow under ideal conditions)
        plantFactors.add(shagBarkHickoryFactors);

        stJohnWortFactors = new ArrayList<Double>();
        stJohnWortFactors.add(25.4); // ideal water in mm
        stJohnWortFactors.add(6.0); // ideal sun in hours
        stJohnWortFactors.add(60.0); // ideal Nitrogen in ppm
        stJohnWortFactors.add(35.0);  // ideal Phosphorous in ppm
        stJohnWortFactors.add(30.0); // ideal Potassium in ppm
        stJohnWortFactors.add(485.0); // ideal Calcium in ppm
        stJohnWortFactors.add(50.0); // ideal Magnesium in ppm
        stJohnWortFactors.add(15.0); // ideal Sulpur in ppm
        stJohnWortFactors.add(1.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        stJohnWortFactors.add(1.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        stJohnWortFactors.add(30.0); // number of days to grow under ideal conditions)
        plantFactors.add(stJohnWortFactors);

        sumacFactors = new ArrayList<Double>();
        sumacFactors.add(25.4); // ideal water in mm
        sumacFactors.add(7.0); // ideal sun in hours
        sumacFactors.add(60.0); // ideal Nitrogen in ppm
        sumacFactors.add(40.0);  // ideal Phosphorous in ppm
        sumacFactors.add(40.0); // ideal Potassium in ppm
        sumacFactors.add(480.0); // ideal Calcium in ppm
        sumacFactors.add(50.0); // ideal Magnesium in ppm
        sumacFactors.add(15.0); // ideal Sulpur in ppm
        sumacFactors.add(0.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        sumacFactors.add(0.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        sumacFactors.add(90.0); // number of days to grow under ideal conditions)
        plantFactors.add(sumacFactors);

        tallMeadowRueFactors = new ArrayList<Double>();
        tallMeadowRueFactors.add(33.0); // ideal water in mm
        tallMeadowRueFactors.add(6.0); // ideal sun in hours
        tallMeadowRueFactors.add(50.0); // ideal Nitrogen in ppm
        tallMeadowRueFactors.add(50.0);  // ideal Phosphorous in ppm
        tallMeadowRueFactors.add(50.0); // ideal Potassium in ppm
        tallMeadowRueFactors.add(485.0); // ideal Calcium in ppm
        tallMeadowRueFactors.add(50.0); // ideal Magnesium in ppm
        tallMeadowRueFactors.add(15.0); // ideal Sulpur in ppm
        tallMeadowRueFactors.add(0.0); // ideal pH (0 = acidic, 1= neutral, 2= basic)
        tallMeadowRueFactors.add(3.0); // ideal soil type (0 is sand, 1 is loam, 2 is silt, 3 is clay)
        tallMeadowRueFactors.add(40.0); // number of days to grow under ideal conditions)
        plantFactors.add(tallMeadowRueFactors);
    }

    private void plantGrowProgress(ArrayList<Double> plant) {
        x = 0;
    }

    
}

    