/* Structs and Pointers
 * Output:
 * Qaz is at memory location 0x2174010< will changed >
 * Name: Qaz    Age: 21
 * Wsx is at memory location 0x2174050
 * Name: Wsx    Age: 36
 */

#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>

struct Person{
    char *name;
    int age;
};
struct Person *person_create(char *name, int age){
    struct Person *who = malloc(sizeof(struct Person));
    assert(who != NULL);
    who->name = strdup(name);
    who->age = age;
    return who;
}
void person_destroy(struct Person *who){
    assert(who != NULL);
    free(who->name);
    free(who);
}
void person_print(struct Person *who){
    printf("Name: %s    Age: %d\n", who->name, who->age);
}

int main(int argc, char *argv[]){
    struct Person *Qaz = person_create("Qaz", 21);
    struct Person *Wsx = person_create("Wsx", 36);
    printf("Qaz is at memory location %p\n", Qaz);
    person_print(Qaz);
    printf("Wsx is at memory location %p\n", Wsx);
    person_print(Wsx);
    person_destroy(Qaz);
    person_destroy(Wsx);

    return 0;
}
