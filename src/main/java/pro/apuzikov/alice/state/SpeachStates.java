package pro.apuzikov.alice.state;

public enum SpeachStates {
    ENDED,
    UNKNOWN_CONTINUE,
    ANSWERED,
    HAPPY_ENDED,
    QUIZING,
    FIRST_QUESTION,
    STARTING;
}


/**
 * -----------------------------------------------NO------------------------------------------------
 * |                                                                                               |
 * |                                                                                               |
 * |                                                                                               |
 * |                                                                                               |
 * |                                                                                               |
 * |                                                                                               |
 * |                                                                                               \/
 * STARTING --------YES------> FIRST_QUESTION ---> QUIZING ---->HAPPY_ENDED ----> ANSWERED ------ > ENDED;
 * |  /\                                                                                         /\
 * |  |                                                                                           |
 * ?  |                                                                                          |
 * |  |                                                                                          |
 * ->UNKNOWN(CONTINUE)--------------------------------NO------------------------------------------
 */