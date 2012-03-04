(ns clj-euler.problems.problem57
  (:use [clj-euler.math :only (num-digits)])
  (:use [clj-euler.lazy-seqs :only (sqrt2-expansions)]))

(defn first-longer [[x y]] (> (num-digits x) (num-digits y)))
(def problem57 (count (filter first-longer (take 1000 (sqrt2-expansions)))))