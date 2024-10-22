// TrigType enum:
// This is used to label whether a trigonometric term is sine (sin(x)) or cosine (cos(x)).
// It helps the TrigTerm class know which function it's working with and how to handle its derivative.


package Calculator;

public enum TrigType {
    SINE, //this represents the sine function
    COSINE //this represents the cosine function
}
