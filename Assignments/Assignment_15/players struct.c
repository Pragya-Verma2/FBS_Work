#include <stdio.h>
#include <string.h>

// Define structure for player
typedef struct {
    char name[50];
    int matches;
    int runs;
    int wickets;
} Player;

// Function to accept information of all players
void acceptPlayers(Player p[], int n) {
    for (int i = 0; i < n; i++) {
        printf("\nEnter details of Player %d:\n", i + 1);

        printf("Enter Name: ");
        scanf("%s", p[i].name);

        printf("Enter Matches Played: ");
        scanf("%d", &p[i].matches);

        printf("Enter Runs Scored: ");
        scanf("%d", &p[i].runs);

        printf("Enter Wickets Taken: ");
        scanf("%d", &p[i].wickets);
    }
}

// Function to display information of all players
void displayPlayers(Player p[], int n) {
    printf("\n%-20s %-10s %-10s %-10s\n", "Name", "Matches", "Runs", "Wickets");
    printf("-------------------------------------------------------------\n");

    for (int i = 0; i < n; i++) {
        printf("%-20s %-10d %-10d %-10d\n",
               p[i].name, p[i].matches, p[i].runs, p[i].wickets);
    }
}

// Function to display player with maximum runs and wickets
void displayTopPlayers(Player p[], int n) {
    int maxRunsIndex = 0;
    int maxWicketsIndex = 0;

    // Find indexes of players with max runs and wickets
    for (int i = 1; i < n; i++) {
        if (p[i].runs > p[maxRunsIndex].runs) {
            maxRunsIndex = i;
        }
        if (p[i].wickets > p[maxWicketsIndex].wickets) {
            maxWicketsIndex = i;
        }
    }

    printf("\nPlayer with Maximum Runs:\n");
    printf("Name: %s | Matches: %d | Runs: %d | Wickets: %d\n",
           p[maxRunsIndex].name, p[maxRunsIndex].matches, p[maxRunsIndex].runs, p[maxRunsIndex].wickets);

    printf("\nPlayer with Maximum Wickets:\n");
    printf("Name: %s | Matches: %d | Runs: %d | Wickets: %d\n",
           p[maxWicketsIndex].name, p[maxWicketsIndex].matches, p[maxWicketsIndex].runs, p[maxWicketsIndex].wickets);
}

int main() {
    int n = 10;
    Player players[10];

    // Accept details of players
    acceptPlayers(players, n);

    // Display all players' information
    displayPlayers(players, n);

    // Display player with max runs & max wickets
    displayTopPlayers(players, n);

    return 0;
}
