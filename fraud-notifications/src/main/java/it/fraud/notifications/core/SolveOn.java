package it.fraud.notifications.core;

import java.util.List;

public class SolveOn {
	
	private static final int MAX_EXPENSE = 200;

    public int activityNotifications(List<Integer> expenditure, int d) {
        int notify = 0;

        // Initialize the frequency array for counting sort
        int[] count = new int[MAX_EXPENSE + 1];
        for (int i = 0; i < d; i++) {
            count[expenditure.get(i)]++;
        }

        for (int i = d; i < expenditure.size(); i++) {
            // Calculate median based on the frequency array
            float median = getMedian(count, d);

            // Check if notification is triggered
            if (expenditure.get(i) >= 2 * median) {
                notify++;
            }

            // Update the frequency array (sliding window technique)
            count[expenditure.get(i)]++;               // Add current element
            count[expenditure.get(i - d)]--;           // Remove the element that's sliding out of the window
        }

        return notify;
    }

    private float getMedian(int[] count, int d) {
        int sum = 0;
        int left = 0, right = 0;

        if (d % 2 == 1) {
            // Odd case: find the middle element
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (sum > d / 2) {
                    return i;
                }
            }
        } else {
            // Even case: find the two middle elements
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (sum == d / 2) {
                    left = i;
                }
                if (sum > d / 2) {
                    right = i;
                    if (left == 0) left = right;
                    return (left + right) / 2.0f;
                }
            }
        }
        return 0;
    }

}
