/* ex1  Types of Variables
 * Output:
 * You are 100 miles away
 * You are 2.345000 kilogram
 * You are 56789.453200 level of power
 * I have an initial A
 * My name is Qaz
 */

#include <stdio.h>

int main(int argc, char* argv[]){
    int distance = 100;
    float weight = 2.345f;
    double power = 56789.4532;
    char inital = 'A';
    char name[] = "Qaz";

    printf("You are %d miles away\n", distance);
    printf("You are %f kilogram\n", weight);
    printf("You are %f level of power\n", power);
    printf("I have an initial %c\n", inital);
    printf("My name is %s\n", name);
    return 0;
}

