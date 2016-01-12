/* Pointer, Arrays
 * (1) type *ptr:           a pointer of type named ptr
 * (2) *ptr:                the value of whatever ptr is pointed at
 * (3) *(ptr+1):            the value of (whatever ptr is pointed at plus i)
 * (4) &thing:              the address of thing
 * (5) type *ptr = &thing   a pointer of type named ptr set to the address of thing(or ptr = &thing)
 * (6) ptr++:               increment where ptr points
 * Output:
 * 16 Qaz
 * 23 Wsx
 * 38 Edc
 * ---
 *  16 Qaz
 *  23 Wsx
 *  38 Edc
 *  ---
 *  16 Qaz
 *  23 Wsx
 *  38 Edc
 *  ---
 *  16 Qaz
 *  23 Wsx
 *  38 Edc
 */

#include <stdio.h>

int main(int argc, char* argv[]){
    int i;
    int ages[] = {16, 23, 38};
    int* cur_age = ages;
    char* names[] = {
        "Qaz",
        "Wsx",
        "Edc"
    };
    char** cur_name = names;
    int count = sizeof(ages)/sizeof(int);

    //int ages[] = {16, 23, 38};
    //char* names[] = {"Qaz", "Wsx", "Edc"};
    for(i = 0; i < count; i++){
        printf("%d %s\n", ages[i], names[i]);
    }
    printf("---\n");

    //int* cur_age = ages;
    //char** cur_name = names;
    for(i = 0; i < count; i++){
        printf("%d %s\n", *(cur_age+i), *(cur_name+i));
    }
    printf("---\n");
    for(i = 0; i < count; i++){
        printf("%d %s\n", cur_age[i], cur_name[i]);
    }
    printf("---\n");

    for(cur_name = names, cur_age = ages; (cur_age-ages) < count; cur_name++, cur_age++){
        printf("%d %s\n", *cur_age, *cur_name);
    }
    return 0;
}
