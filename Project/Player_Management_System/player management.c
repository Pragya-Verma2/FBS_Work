#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int jersey, runs, wickets, matches;
    char name[50];
} Player;

Player *players = NULL; // Dynamic array
int count = 0;

// ------------------ Add Player ------------------
void addPlayer() {
    players = realloc(players, (count + 1) * sizeof(Player));

    printf("Jersey: "); 
    scanf("%d", &players[count].jersey);
    printf("Name: "); 
    getchar(); 
    gets(players[count].name); // beginner-friendly, though unsafe
    printf("Runs: ");
    scanf("%d", &players[count].runs);
    printf("Wickets: ");
    scanf("%d", &players[count].wickets);
    printf("Matches: ");
    scanf("%d", &players[count].matches);

    count++;
    printf("Player Added!\n");
}

// ------------------ Display All Players ------------------
void displayAll() {
    if (count == 0) {
        printf("No players!\n");
        return;
    }

    printf("\n--- All Players ---\n");
    for (int i = 0; i < count; i++) {
        printf("%d %s %d %d %d\n",
               players[i].jersey, players[i].name,
               players[i].runs, players[i].wickets,
               players[i].matches);
    }
}

// ------------------ Search Player ------------------
void searchPlayer() {
    int choice, j;
    char n[50];

    printf("Search by: 1.Jersey 2.Name: "); 
    scanf("%d", &choice);

    if (choice == 1) {
        printf("Jersey: "); scanf("%d", &j);
        for (int i = 0; i < count; i++) {
            if (players[i].jersey == j) {
                printf("Found: %s %d %d %d\n",
                       players[i].name, players[i].runs,
                       players[i].wickets, players[i].matches);
                return;
            }
        }
    } else {
        printf("Name: "); getchar(); gets(n);
        for (int i = 0; i < count; i++) {
            if (strcmp(players[i].name, n) == 0) {
                printf("Found: %d %d %d\n",
                       players[i].jersey, players[i].runs,
                       players[i].wickets);
                return;
            }
        }
    }

    printf("Player Not Found!\n");
}

// ------------------ Update Player ------------------
void updatePlayer() {
    int j;
    printf("Jersey to update: "); scanf("%d", &j);

    for (int i = 0; i < count; i++) {
        if (players[i].jersey == j) {
            printf("Runs: "); scanf("%d", &players[i].runs);
            printf("Wickets: "); scanf("%d", &players[i].wickets);
            printf("Matches: "); scanf("%d", &players[i].matches);
            printf("Player Updated!\n");
            return;
        }
    }

    printf("Player Not Found!\n");
}

// ------------------ Remove Player ------------------
void removePlayer() {
    int j;
    printf("Jersey to remove: "); scanf("%d", &j);

    for (int i = 0; i < count; i++) {
        if (players[i].jersey == j) {
            for (int k = i; k < count - 1; k++)
                players[k] = players[k + 1];

            count--;
            players = realloc(players, count * sizeof(Player));
            printf("Player Removed!\n");
            return;
        }
    }

    printf("Player Not Found!\n");
}


// ------------------ Display Sorted Players ------------------
void displaySorted() {
    if (count == 0) {
        printf("No players!\n");
        return;
    }

    int choice;
    printf("Sort by: 1.Runs 2.Wickets : ");
    scanf("%d", &choice);

    // Copy array so original stays intact
    Player *tempArr = (Player *)malloc(count * sizeof(Player));
    for (int i = 0; i < count; i++)
        tempArr[i] = players[i];

    Player temp;
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            if ((choice == 1 && tempArr[i].runs < tempArr[j].runs) ||
                (choice == 2 && tempArr[i].wickets < tempArr[j].wickets)) {
                temp = tempArr[i];
                tempArr[i] = tempArr[j];
                tempArr[j] = temp;
            }
        }
    }

    printf("\nSorted Players:\n");
    for (int i = 0; i < count; i++) {
        printf("%d %s Runs:%d Wickets:%d Matches:%d\n",
               tempArr[i].jersey, tempArr[i].name,
               tempArr[i].runs, tempArr[i].wickets, tempArr[i].matches);
    }

    free(tempArr);
}

// ------------------ Main Menu ------------------
int main() {
    int ch;
    players = (Player*) malloc(sizeof(Player));

    while (1) {
        printf("\n--- Player Management Menu ---\n");
        printf("1.Add Player\n");
        printf("2.Display All Players\n");
        printf("3.Search Player\n");
        printf("4.Update Player\n");
        printf("5.Remove Player\n");
        printf("6.Display Sorted Players\n");
        printf("7.Exit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);

        switch (ch) {
            case 1: addPlayer(); break;
            case 2: displayAll(); break;
            case 3: searchPlayer(); break;
            case 4: updatePlayer(); break;
            case 5: removePlayer(); break;
            case 6: displaySorted(); break;
            case 7: 
                free(players); 
                exit(0);
            default: printf("Invalid choice!\n");
        }
    }
}