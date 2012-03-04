(ns clj-euler.problems.problem6
  (:use [clj-euler.math :only (sqr)]))

(defn sum-squares [lst] (reduce + (map sqr lst)))
(defn square-sums [lst] (sqr (reduce + lst)))

(def problem6 (Math/abs (- (sum-squares (range 101)) (square-sums (range 101)))))