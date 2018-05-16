import java.text.DecimalFormat;
import java.util.ArrayList;

class PageRank {

    private static double N = 0;
    private static int size;
    private static final double dampingFactor = 0.85;
    private static double offset = 0;
    private static double[] pageRank;
    private static double[] old_pageRank;
    private static int iterations;
    private static ArrayList<Long> times;

    /**
     * Setup variables for page rank algorithm, execute and time algorithm till convergence
     *
     * @param articles Array of articles
     * @return long execution time
     */
    static long rank(Article... articles) {
        N = articles.length;

        offset = (1 - dampingFactor) / N;

        size = articles.length;

        double initialPageRank = 1 / N;
        pageRank = new double[size];
        old_pageRank = new double[size];
        offset = (1 - dampingFactor) / size;

        for (int i = 0; i < size; i++) {
            pageRank[i] = initialPageRank;
            old_pageRank[i] = initialPageRank;
        }

        times = new ArrayList<>();
        int count = 0;
        printPageRank(count);


        long startTime;
        long endTime;
        //Loop until the values converge
        do {
            //Calculate the page rank
            startTime = System.nanoTime();
            calculatePageRank(articles);
            endTime = System.nanoTime();
            ++count;

            //Print the page rank
            if (size <= 10) {
                printPageRank(count);
            }

        } while (!didConverge(count));

        for (int i = 0; i < size; i++) {
            articles[i].setRank(pageRank[i]);
            System.out.println("Title: " + articles[i].getTitle() + ": " + articles[i].getRank());
        }

        for (long time : times) {
            System.out.println(time);
        }
        return (endTime - startTime);
    }

    /**
     * Calculate the page rank
     *
     * @param articles list of articles
     */
    private static void calculatePageRank(Article... articles) {

        double[] newPageRankArray = new double[size];
        double intermediateCalculation;
        for (int i = 0; i < pageRank.length; i++) {
            intermediateCalculation = 0;
            for (int j = 0; j < pageRank.length; j++) {
                if (articles[j].getCitations().contains(articles[i])) {
                    intermediateCalculation += pageRank[j] / articles[j].getNumberOfCitations();
                }
            }
            newPageRankArray[i] = offset + dampingFactor * intermediateCalculation;
        }

        old_pageRank = pageRank;
        pageRank = newPageRankArray;
    }

    /**
     * Print the Page Rank Values
     */
    private static void printPageRank(int iteration) {

        if (iteration == 0) {
            System.out.print("Base : " + iteration + " : ");
        } else {
            System.out.print("Iterat : " + iteration + " : ");
        }

        DecimalFormat numberFormat = new DecimalFormat("0.0000000");

        for (int i = 0; i < pageRank.length; i++) {
            System.out.print("PR[" + i + "] = " + numberFormat.format(pageRank[i]) + " ");
        }
        System.out.println();
    }

    /**
     * Check if the values of page rank converged
     *
     * @return True if the converge is successful
     */
    private static boolean didConverge(int current_iteration) {
        double multiplicationFactor;
        if (iterations > 0) {
            return current_iteration == iterations;
        } else {
            if (iterations == 0) {
                multiplicationFactor = 100000;
            } else {
                multiplicationFactor = Math.pow(10, (iterations * -1));
            }

            for (int i = 0; i < pageRank.length; i++) {
                if ((int) Math.floor(pageRank[i] * multiplicationFactor) != (int) Math.floor(old_pageRank[i] * multiplicationFactor)) {
                    return false;
                }
            }
            return true;
        }
    }
}
