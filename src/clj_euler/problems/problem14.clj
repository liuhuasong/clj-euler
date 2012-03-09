(ns clj-euler.problems.problem14)

(def collatz 
  (memoize (fn 
    ([n] (collatz n 0))
    ([n acc] 
     (cond
	    (= 1 n)   (inc acc)
	    (even? n) (recur (/ n 2) (inc acc))
	    (odd? n)  (recur (inc (* 3 n)) (inc acc)))))))

(def problem14 (first (sort-by #(collatz %) > (range 500001 1000000 2))))