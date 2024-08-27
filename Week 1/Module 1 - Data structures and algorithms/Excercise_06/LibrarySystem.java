import java.util.Arrays;

class Novel {
    private int novelId;
    private String name;
    private String writer;

    public Novel(int novelId, String name, String writer) {
        this.novelId = novelId;
        this.name = name;
        this.writer = writer;
    }

    public int getNovelId() {
        return novelId;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    @Override
    public String toString() {
        return "Novel[ID=" + novelId + ", Name=" + name + ", Writer=" + writer + "]";
    }
}

public class LibrarySystem {

    public static Novel searchByTitle(Novel[] novels, String name) {
        for (Novel novel : novels) {
            if (novel.getName().equalsIgnoreCase(name)) {
                return novel;
            }
        }
        return null;
    }

    public static Novel findNovel(Novel[] novels, String name) {
        int low = 0;
        int high = novels.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = name.compareToIgnoreCase(novels[mid].getName());

            if (comparison == 0) {
                return novels[mid];
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Novel[] novels = {
                new Novel(1, "The Catcher in the Rye", "J.D. Salinger"),
                new Novel(2, "To Kill a Mockingbird", "Harper Lee"),
                new Novel(3, "1984", "George Orwell")
        };

        // Linear Search
        System.out.println("Searching for '1984' using Title Search:");
        Novel foundNovel = searchByTitle(novels, "1984");
        System.out.println(foundNovel != null ? foundNovel : "Novel not found");

        // Binary Search
        // Sorting the array before binary search
        Arrays.sort(novels, (n1, n2) -> n1.getName().compareToIgnoreCase(n2.getName()));

        System.out.println("\nSearching for 'To Kill a Mockingbird' using Binary Search:");
        foundNovel = findNovel(novels, "To Kill a Mockingbird");
        System.out.println(foundNovel != null ? foundNovel : "Novel not found");
    }
}
