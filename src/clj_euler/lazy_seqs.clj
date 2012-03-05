(ns clj-euler.lazy-seqs
  (:use [clj-euler.math :only (sqr amicable?)])
  (:use [clojure.contrib.math :only (exact-integer-sqrt)]))

(defn triangle-numbers [] (reductions  + (iterate inc 1)))

(defn sqrt2-expansions [] (iterate (fn [[n d]] [(+ n (* 2 d)) (+ n d)]) [3 2]))

(defn pyth-triplets []
    "Lazy sequence of all pythagorean triplets"
    (let [triplet-possible? (fn [a b]
        "c² - b² = a²        | c is at least b + 1
        ((b + 1)² - b² <= a² | binomial theorem
        2b + 1 <= a²         | a and b are integers
        2b < a²"
        (< (* 2 b) (sqr a)))]

        (for [a (iterate inc 1)
            b (take-while #(triplet-possible? a %) (iterate inc (inc a))) 
            :let [[c r] (exact-integer-sqrt (+ (sqr a) (sqr b)))]
            :when (= 0 r)] 
            [a b c])))

(defn amicables [] (filter amicable? (iterate inc 1)))