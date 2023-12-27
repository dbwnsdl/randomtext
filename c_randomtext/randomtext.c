#include <stdio.h>
#include <stdlib.h>
#include <time.h> 

char* random_text(int length) {
    char hangul[length + 1];
    char alphabets[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char* combined = (char*)malloc((length * 2 + 1) * sizeof(char));

    srand(time(NULL));

    for (int i = 0; i < length; i++) {
        hangul[i] = rand() % (55203 - 44032 + 1) + 44032;
    }
    hangul[length] = '\0';

    for (int i = 0; i < length * 2; i++) {
        if (i % 2 == 0) {
            combined[i] = hangul[i / 2];
        } else {
            combined[i] = alphabets[rand() % (sizeof(alphabets) - 1)];
        }
    }
    combined[length * 2] = '\0';

    for (int i = length * 2 - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        char temp = combined[i];
        combined[i] = combined[j];
        combined[j] = temp;
    }

    return combined;
}

int main() {
    int length = 10;
    char result[length + 1];

    char* randomResult = random_text(length);
    snprintf(result, sizeof(result), "%s", randomResult);

    printf("%s\n", result);

    free(randomResult); 

    return 0;
}
