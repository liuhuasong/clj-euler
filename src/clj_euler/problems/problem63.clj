(ns clj-euler.problems.problem63
  (:use [clj-euler.math :only (num-digits)])
  (:use [clojure.contrib.math :only (expt)]))

(def problem63 
  (for [x (range 10) n (iterate inc 1)
        :let [power (expt x n) minimum (expt 10 (dec n))] 
        :while (>= power minimum) 
        :when (= n (num-digits power))]
    (str x "^" n "=" power)))

(time (count problem63))