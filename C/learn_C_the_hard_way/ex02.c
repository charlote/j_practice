/* Sizes, Arrays and Strings, Arrays of Strings
 * Output:
 * size of int: 4
 * size of nums(int[]): 20, the number of int in nums: 5
 * the size of a char: 1
 * size of name(char[]): 4, the number of char in name: 4
 * size of full_name(char[]): 6, the number of char in full_name: 6
 * numbers: 0 0 0 0
 * names each: a   
 * names: a
 * numbers: 1 2 3 4
 * names each: Q a z 
 * names: Qaz
 * another: Qaz
 * another each: Q a z 
 * state 0: Qaz : Q a z
 * state 1: Wsx : W s x
 * state 2: Edc : E d c
 */

#include <stdio.h>

int main(int argc, char* argv[]){
    int i = 0;
    int nums[] = {10, 12, 14, 15, 20};
    int numbers[4] = {0};
    char name[] = "Qaz";
    char full_name[] = {'Q', 'a', 'z', ' ', 'W', 's'};
    char names[4] = {'a'};
    char* another = "Qaz";
    char* states[] = {
        "Qaz",
        "Wsx",
        "Edc"
    }; 
    
    //int nums[] = {10, 12, 14, 15, 20};
    //char name[] = "Qaz";
    //char full_name[] = {'Q', 'a', 'z', ' ', 'W', 's'};
    //nums:int*         nums[i]:int(%d)
    //name:char*(%s)    name[i]:char(%c)
    printf("size of int: %ld\n", sizeof(int));
    printf("size of nums(int[]): %ld, the number of int in nums: %ld\n", sizeof(nums), sizeof(nums)/sizeof(int));
    printf("the size of a char: %ld\n", sizeof(char));
    printf("size of name(char[]): %ld, the number of char in name: %ld\n", sizeof(name), sizeof(name)/sizeof(char));
    printf("size of full_name(char[]): %ld, the number of char in full_name: %ld\n", sizeof(full_name), sizeof(full_name)/sizeof(char));

    //int numbers[4] = {0};
    //char names[4] = {'a'};
    //numbers:int*      numbers[i]:int(%d)
    //names:char*(%s)   names[i]:char(%c)
    printf("numbers: %d %d %d %d\n", numbers[0], numbers[1], numbers[2], numbers[3]);
    printf("names each: %c %c %c %c\n", names[0], names[1], names[2], names[3]);
    printf("names: %s\n", names);

    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;
    numbers[3] = 4;
    names[0] = 'Q';
    names[1] = 'a';
    names[2] = 'z';
    names[3] = '\0';
    printf("numbers: %d %d %d %d\n", numbers[0], numbers[1], numbers[2], numbers[3]);
    printf("names each: %c %c %c %c\n", names[0], names[1], names[2], names[3]);
    printf("names: %s\n", names);

    //char* another = "Qaz";
    printf("another: %s\n", another);
    printf("another each: %c %c %c %c\n", another[0], another[1], another[2], another[3]);
    
    //char* states[] = {"Qaz", "Wsx", "Edc"};
    //states:char**     states[i]:char*(%s)     states[i][j]:char(%c)
    for(i = 0; i < 3; i++){
        printf("state %d: %s : %c %c %c\n", i, states[i], states[i][0], states[i][1], states[i][2]);
    }
    return 0;

}

