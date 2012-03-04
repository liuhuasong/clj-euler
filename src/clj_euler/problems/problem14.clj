(ns clj-euler.problems.problem14)

(def collatz 
  (memoize (fn 
    ([n] (collatz n 0))
    ([n acc] 
     (cond
	    (= 1 n)   (inc acc)
	    (even? n) (recur (/ n 2) (inc acc))
	    (odd? n)  (recur (inc (* 3 n)) (inc acc)))))))

(defn my-max-key
  "Returns the x for which (k x), a number, is greatest.
   This is a more efficient version than defined in clojure.core"
  ([k x] x)
  ([k x y] (if (> (k x) (k y)) x y))
  ([k x y & more]
     (second (reduce (fn [x y] (if (> (first x) (first y)) x y))
                     (map #(vector (k %) %) (cons x (cons y more)))))))

(def problem14 (apply my-max-key #(collatz %) (range 500001 1000000 2)))