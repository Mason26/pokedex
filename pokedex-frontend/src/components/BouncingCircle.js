import React, { useState, useEffect } from "react";
import "./BouncingCircle.css";

const BouncingCircle = () => {
  const [circles, setCircles] = useState([
    { id: 1, x: 0, y: 100, speedX: 1, speedY: 1, color: "blue" },
    { id: 2, x: 100, y: 100, speedX: 1, speedY: 2.5, color: "blue" },
    { id: 3, x: 2000, y: 200, speedX: 2, speedY: 1.5, color: "purple" },
    { id: 4, x: 2000, y: 500, speedX: 2, speedY: 0.5, color: "red" },
    { id: 5, x: 300, y: 300, speedX: 1.5, speedY: 2, color: "white" },
    { id: 6, x: 1000, y: 300, speedX: 1.5, speedY: 2, color: "white" },
    { id: 7, x: 1000, y: 0, speedX: 1.5, speedY: 2, color: "red" },
  ]);

  const circleSize = 500; // Size of the circle

  useEffect(() => {
    const maxX = window.innerWidth - circleSize; // Adjust for circle size
    const maxY = window.innerHeight - circleSize; // Adjust for circle size

    const moveCircles = () => {
      setCircles((prevCircles) =>
        prevCircles.map((circle) => {
          let newX = circle.x + circle.speedX;
          let newY = circle.y + circle.speedY;

          // If the circle hits the edges of the screen, reverse its direction
          if (newX <= 0 || newX >= maxX) {
            circle.speedX = -circle.speedX;
          }
          if (newY <= 0 || newY >= maxY) {
            circle.speedY = -circle.speedY;
          }

          newX = Math.max(0, Math.min(newX, maxX));
          newY = Math.max(0, Math.min(newY, maxY));

          return { ...circle, x: newX, y: newY };
        })
      );
    };

    const interval = setInterval(moveCircles, 10); // Adjust speed as needed

    return () => clearInterval(interval);
  }, [circleSize]);

  return (
    <div>
      {circles.map((circle) => (
        <div
          key={circle.id}
          className={`bouncing-circle ${circle.color}`} // Add color class
          style={{ top: circle.y, left: circle.x }}
        >
          {/* You can put any content inside the circle */}
        </div>
      ))}
    </div>
  );
};

export default BouncingCircle;
