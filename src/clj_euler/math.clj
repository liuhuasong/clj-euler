(ns clj-euler.math
  (:use [clojure.contrib.lazy-seqs :only (primes)])
  (:require [clojure.contrib.string :as string])
  (:use [clojure.contrib.math :only (sqrt expt)]))

(defn fac [n] (reduce * (range 1 (inc n))))

(defn divisible? [x y] (zero? (rem x y)))

(defn sqr [x] (* x x))

(defn first-factor [x, lst] (first (filter #(divisible? x %) (take-while #(<= (sqr %) x) lst))))

(defn prime-factors
  ([n] (prime-factors n []))
  ([n acc] (if (>= 1 n) acc 
     (let [factor (first-factor n primes)]
      (if factor 
        (recur (/ n factor) (conj acc factor))
        (conj acc n))))))

(defn digits [x] (map #(mod % 10) (take-while pos? (iterate #(quot % 10) x))))

;this could be more efficient if we had log10 for huge numbers (inc (bigint (log10 x)))
(defn num-digits [x] (count (str  x)))

(defmulti palindromic? class)
(defmethod palindromic? Number [x] (palindromic? (digits x)))
(defn remove-whitespace [lst] (filter #(not (Character/isWhitespace ^Character %)) lst))
(defmethod palindromic? String [x] (palindromic? (remove-whitespace (string/lower-case x))))
(defmethod palindromic? clojure.lang.ISeq [lst] (= lst (reverse lst)))

(defn divisors [x] 
  (mapcat #(distinct (vector % (quot x %))) 
     (filter #(divisible? x %) 
         (take-while #(< % (inc (bigint (sqrt x)))) 
                     (iterate (if (even? x) inc #(+ 2 %)) 1)))))

(defn sum-divisors [x]
  (if (= 0 x) 0
    (reduce *
          (map #(/ (dec (expt (first %) (inc (second %)))) 
                   (dec (first %))) 
                (frequencies (prime-factors x))))))

(defn amicable? [x]
  (let [sum-proper-divisors #(- (sum-divisors %) %) y (sum-proper-divisors x)]
    (and (not= x y) (= x (sum-proper-divisors y)))))

(defn num-divisors [x] 
  (if (= 0 x) 0
    (reduce * (map #(inc (second %)) (frequencies (prime-factors x))))))

(defn totient [x] (* x (reduce * (map #(- 1 (/ 1 %)) (distinct (prime-factors x))))))
