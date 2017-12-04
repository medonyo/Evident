package com.main.EvidentApp;

// Class is intended to contain data related to the visitor.
// It shall describe state of person in a day he was registered on.
public class DiseaseCard {

    public enum fstate {
        NORMAL, NOT_NORMAL
    }

    private fstate mucousMembrane;
    private fstate periodontium;
    private fstate hygiene;

    private String pulpPathology;
    private String apicalForamenPathology;
    private String plaque;
    private String gumsBleed;

    private int teethColorPictNo;
    private int mouthPictNo;

    DiseaseCard() {
        // default data.
    }

}
