import React, { useState } from "react";
import { StyleSheet } from "react-native";
import { Image, Dimensions } from "react-native";
import { ImageBackground, TouchableOpacity } from "react-native";
import { Text } from "react-native";
import { View } from "react-native";
import { BACKGROUND_COLOR, SCREEN_PADDING } from "../../../variables";

interface Position {
  top: number | string;
  left: number | string;
  width: string;
}

const CountingActivityScreen = ({ route }: { route: any }) => {
  const { option } = route.params;
  const [numCowsFound, setNumCowsFound] = useState<number>(0);
  const [height, setHeight] = useState(Dimensions.get("window").height)
  const [width, setWidth] = useState(Dimensions.get("window").width)
  const [imgWidth, setImgWidth] = useState<number>(0)
  const [imgHeight, setImgHeight] = useState<number>(0)

  const bgUri = Image.resolveAssetSource(require("./images/Background.png")).uri
  Image.getSize(bgUri, (w,h) => {
    setImgHeight(h)
    setImgWidth(w)
  })

  const getDistance = (distCenter: number, axis: string) => {
    const offScreenX = (imgWidth - width) / 2 > 0 ? (imgWidth - width) / 2  : 0;
    const offScreenY = (imgHeight - height) / 2 > 0 ?  (imgHeight - height) / 2 : 0;

    if (axis == "y") {
      const y = imgHeight/2 + distCenter - offScreenY
      return y
    } else {

      const x = imgWidth/2 + distCenter + offScreenX
      return x
    }
  }

  const babyCowPositions: Array<Position> = [
    {
      top: getDistance(0, "y"), // 66%
      left: getDistance(0,"x"), // 16
      width: "20%",
    },
  ];
  
  const onBabyCowPress = () => {
    console.log("found cow");
  };

  return (
    <View style={styles.root}>
      <ImageBackground
        source={require("./images/Background.png")}
        style={styles.bgImg}
      >
        {babyCowPositions.map((babyCowPosition, index) => {
          console.log(babyCowPosition)
          return (
            <TouchableOpacity
              key={index}
              onPress={() => onBabyCowPress()}
              style={[styles.babyCowContainer, babyCowPosition]}
            >
              <Image
                style={styles.babyCow}
                source={require("./images/babyCows/bCow1.png")}
              />
            </TouchableOpacity>
          );
        })}
        <View style={styles.mamaCowContainer}>
          <Image
            source={require("./images/mamaCow.png")}
            style={styles.mamaCow}
          />
        </View>
      </ImageBackground>
    </View>
  );
};

const styles = StyleSheet.create({
  root: {
    // paddingTop: SCREEN_PADDING,
    flex: 1,
    backgroundColor: BACKGROUND_COLOR,
  },
  bgImg: {
    height: "100%",
    resizeMode: "center",
    flex: 1,
  },
  mamaCowContainer: {
    position: "absolute",
    top: "75%",
    right: "5%",
    width: "50%",

  },
  mamaCow: {
    width: "100%",
    resizeMode: "contain",
  },
  babyCowContainer: {
    position: "absolute",
    // borderColor: "red",
    // borderWidth: 2,
  },
  babyCow: {
    width: "100%",
    resizeMode: "contain",
  },
});

export default CountingActivityScreen;
