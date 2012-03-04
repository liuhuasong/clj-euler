(ns clj-euler.problems.problem51
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:use [clj-euler.math :only (digits)])
  (:use [clojure.contrib.seq :only (positions)])
  (:use [clojure.contrib.combinatorics :only (combinations)]))

(defn repeating-digit [n] (ffirst (filter #(>= (second %) 3) (frequencies (digits n)))))
(defn possible-masks [n] (combinations (positions #{(repeating-digit n)} (reverse (digits n))) 3))
(defn apply-mask [mask n] (apply str (map-indexed #(if (some #{%1} mask) "x" %2) (reverse (digits n)))))
(defn families [n] (map #(apply-mask % n) (possible-masks n)))
(defn family-map [n] (apply merge (map #(hash-map % [n]) (families n))))
(defn family-comb [lst] (apply merge-with concat (map family-map lst)))


(defn take-between [l h lst]
  (take-while #(< % h) (drop-while #(< % l) lst)))

(def problem51 
  (first 
    (filter #(= 8 (count (second %))) 
      (family-comb 
        (take-between 100000 1000000 primes)))))