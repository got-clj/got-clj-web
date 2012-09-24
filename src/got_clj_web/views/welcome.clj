(ns got-clj-web.views.welcome
  (:require [got-clj-web.views.common :as common]
            [got-clj-web.models.twitter :as tw]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [analemma.charts :only [emit-svg xy-plot add-points]]
        [analemma.svg]))


(defpage "/welcome" []
         (common/layout
          [:div.tweets
           [:h1 "Got Clj Tweets"]
           [:div
            [:h1 "Frequencies"]
            (emit-svg (->
                       (xy-plot :xmin 0
                                :maxx 10
                                :ymin 0
                                :maxy 10
                                :height 500
                                :width 500)
                       (add-points [[0 0] [1 1] [2 2]])))]
           [:ul
            (for [tweet (tw/fetch-new-tweets)]
              [:li [:h2 tweet]])]]))
          

