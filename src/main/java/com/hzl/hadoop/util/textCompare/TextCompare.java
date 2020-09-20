package com.hzl.hadoop.util.textCompare;

import java.util.LinkedList;

/**
 * description
 *
 * @author hzl 2020/09/17 11:45 AM
 */
public class TextCompare {

	public static void main(String args[]) {
		diff_match_patch dmp = new diff_match_patch();
		LinkedList<diff_match_patch.Diff> diff = dmp.diff_main("122","1212222235f",true);
		// Result: [(-1, "Hell"), (1, "G"), (0, "o"), (1, "odbye"), (0, " World.")]
		dmp.diff_cleanupSemantic(diff);
		// Result: [(-1, "Hello"), (1, "Goodbye"), (0, " World.")]
		System.out.println(diff);
	}

}
