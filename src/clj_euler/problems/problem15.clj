(ns clj-euler.problems.problem15
  (:use [clj-euler.math :only (fac)]))

(defn choose [n k] (/ (fac n) (* (fac k) (fac (- n k)))))

(def problem15 (choose 40 20))