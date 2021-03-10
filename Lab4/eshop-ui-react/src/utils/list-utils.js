export default function sort(array, field) {
    if (!Array.isArray(array)) {
        return array;
    }
    array.sort((a, b) => {
        if (a[field] < b[field]) {
            return -1;
        } else if (a[field] > b[field]) {
            return 1;
        } else {
            return 0;
        }
    });
    return array;
}
