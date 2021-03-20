export default function generateColor() {
    const colors = ['#002e96', '#80198c', '#ba0072', '#db2950', '#e55d2c', '#db8d00', '#bfb800'];
    return colors[Math.floor(Math.random() * colors.length)];
}
