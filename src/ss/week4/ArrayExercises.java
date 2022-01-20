//package ss.week4;
//
//public class ArrayExercises {
//    public static int countNegativeNumbers(int[] arr) {
//        int negativeNumber = 0;
//        for(int i = 0; i < arr.length ; i++)
//            if (arr[i] < 0)
//                negativeNumber++;
//            return negativeNumber;
//
//    }
//
//    public static int[] reverseArray(int[] ints) {
//       // Collections.reverse(Arrays.asList(ints));
//        for (int i = 0; i < ints.length/2; i++) {
//            if (i < ints.length-1-i) {
//                int left = ints[i];
//                int right = ints[ints.length-1-i];
//                ints[i] = right;
//                ints[ints.length-1-i] = left;
//            }
//        }
//    }
//
//    class SimpleList {
//        public class Element {}
//
//        public class Node {
//            public Node next;
//            public Element element;
//        }
//
//        private Node first;
//
//        private Node find(Element element) {
//            Node p = first;
//            if (p == null) {
//                return null;
//            }
//            while (p.next != null && !p.next.element.equals(element)) {
//                p = p.next;
//            }
//            if (p.next == null) {
//                return null;
//            } else {
//                return p;
//            }
//        }
//
//        public void remove(Element element) {
//            Node p = find(element);
//            if (p != null) {
//                p.next = p.next.next;
//            }
//        }
//    }
//}
