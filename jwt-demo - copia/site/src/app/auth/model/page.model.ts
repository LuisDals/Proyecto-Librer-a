export interface Page<T> {
    last: boolean;
    first: boolean;
    content: T[];
    totalElements: number;
    totalPages: number;
    size: number;
    number: number;
}