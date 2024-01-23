package org.example;

public class LeafGarden {

    public static int remainingLeaves(int width, int height, int[][] leaves, String winds) {
        // Check if the garden is empty
        if (leaves == null || leaves.length == 0 || leaves[0].length == 0) {
            return 0;
        }

        for (char wind : winds.toCharArray()) {
            moveLeaves(width, height, leaves, wind);
        }

        return countRemainingLeaves(leaves);
    }

    private static void moveLeaves(int width, int height, int[][] leaves, char wind) {
        int[][] newLeaves = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int ni = i, nj = j;

                switch (wind) {
                    case 'U':
                        ni = Math.max(0, i - 1);
                        break;
                    case 'D':
                        ni = Math.min(height - 1, i + 1);
                        break;
                    case 'L':
                        nj = Math.max(0, j - 1);
                        break;
                    case 'R':
                        nj = Math.min(width - 1, j + 1);
                        break;
                }

                newLeaves[ni][nj] += leaves[i][j];
            }
        }

        // Copy the new configuration back to the original array
        for (int i = 0; i < height; i++) {
            System.arraycopy(newLeaves[i], 0, leaves[i], 0, width);
        }
    }

    private static int countRemainingLeaves(int[][] leaves) {
        int count = 0;
        for (int[] row : leaves) {
            for (int value : row) {
                count += value;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int width = 4;
        int height = 4;
        int[][] leaves = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        String winds = "RRD";

        int remaining = remainingLeaves(width, height, leaves, winds);
        System.out.println("Remaining leaves: " + remaining);
    }
}

