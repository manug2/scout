# scout-at
To run all features: mvn verify -Pit

To run feature with tag 'init' : mvn verify -Pit -Dcucumber.options="--tags @init"

To run headless browser or specific browser : mvn verify -Pit -Dbrowser=UNIT

