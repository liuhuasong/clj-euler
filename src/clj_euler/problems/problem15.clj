(ns clj-euler.problems.problem15)

(defn fac [n] (reduce * (range 1 (inc n))))
(defn choose [n k] (/ (fac n) (* (fac k) (fac (- n k)))))

(def problem15 (choose 40 20))