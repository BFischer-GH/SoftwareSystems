package ss.week4;

import java.util.List;
import java.util.ArrayList;

public class MergeSort {

	public static <E extends Comparable<E>> List<E> mergeSort(List<E> data) {
		if (data.isEmpty() || data.size() == 1) {
			return data;
		} else {
			List<E> first = new ArrayList<>();
			List<E> second = new ArrayList<>();
			List<E> result = new ArrayList<>();
			for (int i = 0; i < data.size(); i++) {
				if (i < data.size() / 2) {
					first.add(data.get(i));
				} else {
					second.add(data.get(i));
				}
			}

			first = mergeSort(first); // Recursieve functie, anders doet hij het maar 1 keer en niet totdat alles is verdeelt tot 1
			second = mergeSort(second);

			int fi = 0;
			int si = 0;

			while (fi < first.size() && si < second.size()) {
				if (first.get(fi).compareTo(second.get(si)) < 0) {
					result.add(first.get(fi));
					fi++;
				} else{
					result.add(second.get(si));
					si++;
				}
			}

			if (fi < first.size()) {
				for (int j = fi; j < first.size(); j++) {
					result.add(first.get(fi));
					fi++;
				}
			}
			if (si < second.size()) {
				for (int j = si; j < second.size(); j++) {
					result.add(second.get(si));
					si++;
				}
			}
			return result;
		}
	}
}
