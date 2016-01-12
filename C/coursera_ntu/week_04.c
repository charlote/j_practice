#include <stdio.h>

int value(int type, int width, int height, int length){
    int i, j, tmp, size;
    int a[3];
    int val = 0;
    int type_v = 0;
    int volume = 0;

    if((width<1) || (height<1) || (length<1)){
        val = -2;
    }
    a[0] = width;
    a[1] = height;
    a[2] = length;
    // count the GCD; (1)bubble sort -> width/height/length (2)get the gcd
    for(i=0;i<(3-1);i++){
        for (j=1;j<3;j++){
            if(a[i] > a[j]){
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }
    for(i=a[0];i>0;i--){
        if((a[0]%i == 0) && (a[1]%i == 0) && (a[2]%i == 0)){
            size = i;
            break;
        }
    }

    switch(type){
        case 79:
            type_v = 30;
            break;
        case 47:
            type_v = 10;
            break;
        case 29:
            type_v = 4;
            break;
        case 82:
            type_v = 5;
            break;
        case 26:
            type_v = 3;
            break;
        case 22:
            type_v = 9;
            break;
        default:
            val = -1;
    }
    if(val == 0){
        val = type_v * (size*size*size) * (a[0]*a[1]*a[2]);
    }

    return val;
}

int main()
{
    int type, width, height, length;
    scanf("%d %d %d %d", &type, &width, &height, &length);
    printf("%d\n", value(type, width, height, length));
    return 0;
}
