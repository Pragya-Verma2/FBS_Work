#include <stdio.h>

int main() {
    char ch;

    printf("Enter a character: ");
    scanf(" %c", &ch);  // Added space before %c to skip whitespace

    if ((ch >= 'A' && ch <= 'Z')) {
        printf("%c is Uppercase\n", ch);
    } 
    else if (ch >= 'a' && ch <= 'z') {
        printf("%c is Lowercase\n", ch);
    } 
    else {
        printf("%c is not an alphabet character\n", ch);
    }

    return 0;
}
