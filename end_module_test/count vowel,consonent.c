#include <stdio.h>

int main() {
    char str[100];  

    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);   

    int i = 0, vowels = 0, consonants = 0, spaces = 0;

    while (str[i] != '\0') {
        char ch = str[i];

     
        if (ch == ' ') {
            spaces++;
        }
        else if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
                 ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
            vowels++;
        }else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            consonants++;
        }
        i++;
    }

    printf("Number of vowels: %d\n", vowels);
    printf("Number of consonants: %d\n", consonants);
    printf("Number of spaces: %d\n", spaces);

    return 0;
}
