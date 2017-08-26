package dasinjava.recursion;
import java.io.File;
public class DiskUsageExample {
    public static long diskUsage(File root) {
    	long total = root.length();							// start with direct disk usage
    	if (root.isDirectory()){							// and if this is a directory
    		for (String childname: root.list()) {			// then for each child
    			File child = new File(root, childname);		// compose full path to child
    			total += diskUsage(child);					// add child's usage to total
    		}
    	}
    	System.out.println(total + "\t" + root);
    	return total;
    }
    public static void main(String[] args) {
    	File r = new File("C:/Users/Chengxi/Dropbox/NCGIA");
    	diskUsage(r);
    }

}
	